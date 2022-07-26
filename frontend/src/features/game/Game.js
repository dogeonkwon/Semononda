import './Game.css';
import invite from './invite.png'
import exit from './exit.png'
import ready from './ready.png'

const Game = () => {
  return (
    <div className="gamediv">
      <div className="camdiv">
        <div className="box"></div>
        <div className="box"></div>
        <div className="box"></div>
      </div>
      <div className="kingdiv">
        <div className="king"></div>
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
        <div className="box"></div>
        <div className="box"></div>
        <div className="box"></div>
      </div>
      <div className="chatdiv">
        <div className="chat"></div>
        <div className="icons">
          <img className="icon" alt="ready" src={ready}/>
          <img className="icon" alt="invite" src={invite}/>
          <img className="icon" alt="exit" src={exit}/>
        </div>
      </div>
    </div>
  );
};

export default Game;