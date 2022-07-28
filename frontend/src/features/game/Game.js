import './Game.css';
import invite from './invite.png'
import exit from './exit.png'
import ready from './ready.png'
import axios from 'axios';
import { OpenVidu } from 'openvidu-browser';
import React, { Component, createRef } from 'react';
import UserVideoComponent from './UserVideoComponent'
import Messages from './Messages'
import { useParams } from 'react-router-dom';

const OPENVIDU_SERVER_URL = 'https://' + window.location.hostname + ':4443';
const OPENVIDU_SERVER_SECRET = 'MY_SECRET';

function withRouter(Component) {
  function ComponentWithRouter(props) {
    let params = useParams()
    return <Component {...props} params={params} />
  }
  return ComponentWithRouter
}

class Game extends Component {
  constructor(props) {
    super(props);
    this.state = {
        mySessionId: this.props.params.id,
        myUserName: 'Participant' + Math.floor(Math.random() * 100),
        session: undefined,
        mainStreamManager: undefined,
        publisher: undefined,
        subscribers: [],
        messages: [],
    };

    this.joinSession = this.joinSession.bind(this);
    this.leaveSession = this.leaveSession.bind(this);
    this.switchCamera = this.switchCamera.bind(this);
    this.handleChangeSessionId = this.handleChangeSessionId.bind(this);
    this.handleChangeUserName = this.handleChangeUserName.bind(this);
    this.handleMainVideoStream = this.handleMainVideoStream.bind(this);
    this.onbeforeunload = this.onbeforeunload.bind(this);
    this.messageContainer = createRef(null);
    this.sendmessageByClick = this.sendmessageByClick.bind(this);
    this.sendmessageByEnter = this.sendmessageByEnter.bind(this);
    this.handleChatMessageChange = this.handleChatMessageChange.bind(this);
  }

  componentDidMount() {
    window.addEventListener('beforeunload', this.onbeforeunload);
    this.joinSession();
  }

  componentWillUnmount() {
      window.removeEventListener('beforeunload', this.onbeforeunload);
  }

  componentDidUpdate(previousProps, previousState) {
    if (this.refs.chatoutput != null) {
      this.refs.chatoutput.scrollTop = this.refs.chatoutput.scrollHeight;
    }
  }

  onbeforeunload(event) {
      this.leaveSession();
  }

  handleChangeSessionId(e) {
      this.setState({
          mySessionId: e.target.value,
      });
  }

  handleChangeUserName(e) {
      this.setState({
          myUserName: e.target.value,
      });
  }

  handleMainVideoStream(stream) {
      if (this.state.mainStreamManager !== stream) {
          this.setState({
              mainStreamManager: stream
          });
      }
  }

  deleteSubscriber(streamManager) {
      let subscribers = this.state.subscribers;
      let index = subscribers.indexOf(streamManager, 0);
      if (index > -1) {
          subscribers.splice(index, 1);
          this.setState({
              subscribers: subscribers,
          });
      }
  }

  joinSession() {
      // --- 1) Get an OpenVidu object ---
  
      this.OV = new OpenVidu();
  
      // --- 2) Init a session ---
  
      this.setState(
          {
              session: this.OV.initSession(),
        },
        () => {
              var mySession = this.state.session;

              // --- 3) Specify the actions when events take place in the session ---

              // On every new Stream received...
              mySession.on('streamCreated', (event) => {
                  // Subscribe to the Stream to receive it. Second parameter is undefined
                  // so OpenVidu doesn't create an HTML video by its own
                  var subscriber = mySession.subscribe(event.stream, undefined);
                  var subscribers = this.state.subscribers;
                  subscribers.push(subscriber);

                  // Update the state with the new subscribers
                  this.setState({
                      subscribers: subscribers,
                  });
              });

              mySession.on('signal:chat', (event) => {
                let chatdata = event.data.split(',');
                if (chatdata[0] !== this.state.myUserName) {
                  this.setState({
                    messages: [
                      ...this.state.messages,
                      {
                        userName: chatdata[0],
                        text: chatdata[1],
                        chatClass: 'messages__item--visitor',
                      },
                    ],
                  });
                }
              });

              // On every Stream destroyed...
              mySession.on('streamDestroyed', (event) => {
              
                  // Remove the stream from 'subscribers' array
                  this.deleteSubscriber(event.stream.streamManager);
              });
            
              // On every asynchronous exception...
              mySession.on('exception', (exception) => {
                  console.warn(exception);
              });
            
              // --- 4) Connect to the session with a valid user token ---
            
              // 'getToken' method is simulating what your server-side should do.
              // 'token' parameter should be retrieved and returned by your own backend
              this.getToken().then((token) => {
                  // First param is the token got from OpenVidu Server. Second param can be retrieved by every user on event
                  // 'streamCreated' (property Stream.connection.data), and will be appended to DOM as the user's nickname
                  mySession
                      .connect(
                          token,
                          { clientData: this.state.myUserName },
                      )
                      .then(async () => {
                          var devices = await this.OV.getDevices();
                          var videoDevices = devices.filter(device => device.kind === 'videoinput');
                      
                          // --- 5) Get your own camera stream ---
                      
                          // Init a publisher passing undefined as targetElement (we don't want OpenVidu to insert a video
                          // element: we will manage it on our own) and with the desired properties
                          let publisher = this.OV.initPublisher(undefined, {
                              audioSource: undefined, // The source of audio. If undefined default microphone
                              videoSource: videoDevices[0].deviceId, // The source of video. If undefined default webcam
                              publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
                              publishVideo: true, // Whether you want to start publishing with your video enabled or not
                              resolution: '640x480', // The resolution of your video
                              frameRate: 30, // The frame rate of your video
                              insertMode: 'APPEND', // How the video is inserted in the target element 'video-container'
                              mirror: false, // Whether to mirror your local video or not
                          });
                        
                          // --- 6) Publish your stream ---
                        
                          mySession.publish(publisher);
                        
                          // Set the main video in the page to display our webcam and store our Publisher
                          this.setState({
                              currentVideoDevice: videoDevices[0],
                              mainStreamManager: publisher,
                              publisher: publisher,
                          });
                      })
                      .catch((error) => {
                          console.log('There was an error connecting to the session:', error.code, error.message);
                      });
              });
          },
      );
  }

  leaveSession() {

      // --- 7) Leave the session by calling 'disconnect' method over the Session object ---

      const mySession = this.state.session;

      if (mySession) {
          mySession.disconnect();
      }

      // Empty all properties...
      this.OV = null;
      this.setState({
          session: undefined,
          subscribers: [],
          mySessionId: this.props.params.id,
          myUserName: 'Participant' + Math.floor(Math.random() * 100),
          mainStreamManager: undefined,
          publisher: undefined
      });
  }

  async switchCamera() {
      try{
          const devices = await this.OV.getDevices()
          var videoDevices = devices.filter(device => device.kind === 'videoinput');

          if(videoDevices && videoDevices.length > 1) {

              var newVideoDevice = videoDevices.filter(device => device.deviceId !== this.state.currentVideoDevice.deviceId)

              if (newVideoDevice.length > 0){
                  // Creating a new publisher with specific videoSource
                  // In mobile devices the default and first camera is the front one
                  var newPublisher = this.OV.initPublisher(undefined, {
                      videoSource: newVideoDevice[0].deviceId,
                      publishAudio: true,
                      publishVideo: true,
                      mirror: true
                  });

                  //newPublisher.once("accessAllowed", () => {
                  await this.state.session.unpublish(this.state.mainStreamManager)

                  await this.state.session.publish(newPublisher)
                  this.setState({
                      currentVideoDevice: newVideoDevice,
                      mainStreamManager: newPublisher,
                      publisher: newPublisher,
                  });
              }
          }
        } catch (e) {
          console.error(e);
        }
  }

  sendmessageByClick() {
    this.setState({
      messages: [
        ...this.state.messages,
        {
          userName: this.state.myUserName,
          text: this.state.message,
          chatClass: 'messages__item--operator',
        },
      ],
    });
    const mySession = this.state.session;

    mySession.signal({
      data: `${this.state.myUserName},${this.state.message}`,
      to: [],
      type: 'chat',
    });

    this.setState({
      message: '',
    });
  }

  sendmessageByEnter(e) {
    if (e.key === 'Enter') {
      this.setState({
        messages: [
          ...this.state.messages,
          {
            userName: this.state.myUserName,
            text: this.state.message,
            chatClass: 'messages__item--operator',
          },
        ],
      });
      const mySession = this.state.session;

      mySession.signal({
        data: `${this.state.myUserName},${this.state.message}`,
        to: [],
        type: 'chat',
      });

      this.setState({
        message: '',
      });
    }
  }

  handleChatMessageChange(e) {
    this.setState({
      message: e.target.value,
    });
  }

  render(){
    const onClick = e => {
      alert('준비완료')
      console.log(e)
    };
    
    const messages = this.state.messages;

    return (
      <div className="gamediv">
        <div className="camdiv">
          <div className="stream-container">
            <UserVideoComponent streamManager={this.state.publisher1} />
          </div>
          <div className="stream-container">
            <UserVideoComponent streamManager={this.state.publisher1} />
          </div>
          <div className="stream-container">
            <UserVideoComponent streamManager={this.state.publisher1} />
          </div>
        </div>
        <div className="kingdiv">
          <div className="stream-container">
            <UserVideoComponent streamManager={this.state.publisher1} />
          </div>
          <div className="titlediv">
            <div className="title">
              <div className="titlecontent">
                <p className="subject">안건</p>
                <p className="subjectcontent">남녀사이엔 친구가 존재하는가.</p>
                <p>가. 남녀사이엔 친구가 존재 한다.</p>
                <p>나. 아니다. 남녀사이에 친구가 왠 말이냐</p>
              </div>
            </div>
          </div>
        </div>
        <div className="camdiv">
          <div className="stream-container">
            <UserVideoComponent streamManager={this.state.publisher1} />
          </div>
          <div className="stream-container">
            <UserVideoComponent streamManager={this.state.publisher1} />
          </div>
          <div className="stream-container">
            <UserVideoComponent streamManager={this.state.publisher1} />
          </div>
        </div>
        <div className="chatdiv">
          <div className="chatbg"> 
            <div className="chatbox">
              <div className="chatbox__messages" ref="chatoutput">
                {/* {this.displayElements} */}
                <Messages messages={messages} />
              </div>
              <div className="chat chatbox__footer">
                <input
                  id="chat_message"
                  type="text"
                  placeholder="Write a message..."
                  onChange={this.handleChatMessageChange}
                  onKeyPress={this.sendmessageByEnter}
                  value={this.state.message}
                />
                <p
                  className="chat chatbox__send--footer"
                  onClick={this.sendmessageByClick}
                >
                  보내기
                </p>
              </div>
            </div>
          </div>
          <div className="icons">
            <img className="ready-icon" alt="ready" src={ready} onClick={onClick}/>
            <img className="icon" alt="invite" src={invite}/>
            <img className="icon" alt="exit" src={exit}/>
          </div>
        </div>
      </div>
    );
  }

  getToken() {
    return this.createSession(this.state.mySessionId).then((sessionId) => this.createToken(sessionId));
  }

  createSession(sessionId) {
      return new Promise((resolve, reject) => {
          var data = JSON.stringify({ customSessionId: sessionId });
          axios
              .post(OPENVIDU_SERVER_URL + '/openvidu/api/sessions', data, {
                  headers: {
                      Authorization: 'Basic ' + btoa('OPENVIDUAPP:' + OPENVIDU_SERVER_SECRET),
                      'Content-Type': 'application/json',
                  },
              })
              .then((response) => {
                  console.log('CREATE SESION', response);
                  resolve(response.data.id);
              })
              .catch((response) => {
                  var error = Object.assign({}, response);
                  if (error?.response?.status === 409) {
                      resolve(sessionId);
                  } else {
                      console.log(error);
                      console.warn(
                          'No connection to OpenVidu Server. This may be a certificate error at ' +
                          OPENVIDU_SERVER_URL,
                      );
                      if (
                          window.confirm(
                              'No connection to OpenVidu Server. This may be a certificate error at "' +
                              OPENVIDU_SERVER_URL +
                              '"\n\nClick OK to navigate and accept it. ' +
                              'If no certificate warning is shown, then check that your OpenVidu Server is up and running at "' +
                              OPENVIDU_SERVER_URL +
                              '"',
                          )
                      ) {
                          window.location.assign(OPENVIDU_SERVER_URL + '/accept-certificate');
                      }
                  }
              });
      });
  }

  createToken(sessionId) {
      return new Promise((resolve, reject) => {
          var data = {};
          axios
              .post(OPENVIDU_SERVER_URL + "/openvidu/api/sessions/" + sessionId + "/connection", data, {
                  headers: {
                      Authorization: 'Basic ' + btoa('OPENVIDUAPP:' + OPENVIDU_SERVER_SECRET),
                      'Content-Type': 'application/json',
                  },
              })
              .then((response) => {
                  console.log('TOKEN', response);
                  resolve(response.data.token);
              })
              .catch((error) => reject(error));
      });
  }
};

const HOCTaskDetail = withRouter(Game)
export default HOCTaskDetail;