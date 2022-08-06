import React, {useState} from 'react'
import {Button, Form, FormGroup} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import { useDispatch } from 'react-redux';
import { useNavigate}from 'react-router-dom'
import styled from "styled-components";
import {signup, checkNickname, checkId} from '../UserSlice';

//이미지 파일 import
import dark_base from "../../../assets/images/dark_base.PNG"
import userform_img from "../../../assets/images/userform_img.png"
import signup_img from "../../../assets/images/signup_img.png"

//메인페이지 배경화면 Container
const Container = styled.div`
    display: block;
    position: relative;
    width: 100%;
    height: 100vh;
    max-width: 100%;
    max-height: 100%;
    background: center;
    background-color: black;
    background-repeat: no-repeat;
    background-image: url(${dark_base});
    background-size: cover;
    overflow: scroll;`

//로고 영역
const LogoWrapper = styled.div`
  display: flex;
  flex: 1;
  justify-content: center;
  align-items: center;
  width: 40%;
  height: 40%;
  margin: 0 auto;
  margin-bottom: 0.5em;
  `
//로고 이미지
const SingUpLogo = styled.img`
  width: 100%;
  height: 100%;
  flex: 1;
  margin-bottom: 10px;
  text-align: top;`

function Signin() {

    const dispatch = useDispatch();
    const history = useNavigate();

    //서버로 전달할 user객체
   const [user, setUser] = useState({
    id : "",
    name: "",
    nickname : "",
    password : "",
    phonenumber : ""
   })

   //user객체 바인딩
   const { id, name, nickname, password, phonenumber } = user;

    //비밀번호 확인을 위한 변수
   const [confirmPassword, setConfirmPassword] = useState("");

    
     //오류메시지 상태저장
    const [idMessage, setIdMessage] = useState('')
    const [nicknameMessage, setNicknameMessage] = useState('')
    const [passwordMessage, setPasswordMessage] = useState('')
    const [confirmPasswordMessage, setConfirmPasswordMessage] = useState('') 
    const [phonenumberMessage, setPhonenumberMessage] = useState('')

    // 유효성 검사 상태 저장
    const [isId, setIsId] = useState(false);
    const [isNickname, setIsNickname] = useState(false)
    const [isPassword, setIsPassword] = useState(false)
    const [isConfirmPassword, setIsConfirmPassword] = useState(false)
    const [isPhonenumber, setIsPhonenumber] = useState(false)

    //유효성 검사
    //아이디
    const onChangeId = (e) => {
        //숫자, 영어만 사용
        const idRegex = /([0-9a-zA-Z])/
        const { name, value } = e.target;
        setUser({
            ...user, 
            [name]: value,
          });
        //글자 수 5~16 제한
        if (!idRegex.test(user.id) || e.target.value.length < 5 || e.target.value.length > 16) {
          setIdMessage('5~16글자로 입력해주세요.')
          setIsId(false)
        } else {
          setIdMessage('확인되었습니다.')
          setIsId(true)
        }
      }
    
    //이름
    const onChangeName = (e) => {
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value
        });
        //글자 수 30자 이내로 제한
        if(e.target.value.length >30) {
            alert('30자 이내로 입력 가능합니다.')
        } else {
        }
    }

    //닉네임
    const onChangeNickname = (e) => {
        //한글, 영어, 숫자 사용가능
        const nicknameRegex = /([ㄱ-ㅎ|가-힣|0-9|a-z|A-Z])/
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value
        });
        //30자 이내로 입력가능
        if(!nicknameRegex.test(user.nickname) || e.target.value.length >30) {
            setNicknameMessage('30자 이내로 입력 가능합니다.')
            setIsNickname(false)
        }else {
            setNicknameMessage('확인되었습니다.')
            setIsNickname(true)
        }
    }

    //비밀번호
    const onChangePassword = (e) => {
        console.log(e.target.value)
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value,
        });
        //9~16글자 작성가능
        if(e.target.value.length <9 || e.target.value.length >16){
            setPasswordMessage('9~16글자로 입력해주세요')
            setIsPassword(false)
        } else {
            setPasswordMessage('확인되었습니다.')
            setIsPassword(true)
        }
    }

    //비밀번호 확인
    const onChangeConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);
        //비밀번호와 비밀번호 확인이 다른경우
        if(user.password !== e.target.value){
            setConfirmPasswordMessage('비밀번호가 일치하지 않습니다.')
            setIsConfirmPassword(false)
        } else {
            setConfirmPasswordMessage('확인되었습니다.')
            setIsConfirmPassword(true)
        }
    }

    //전화번호
    const onChangePhoneNumber = (e) => {
        //숫자만 입력
        const phonenumberRegex = /[0-9]/;
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value,
        });
        if(!phonenumberRegex.test(user.phonenumber) || e.target.value.length !== 11){
            console.log(e)
            setPhonenumberMessage('전화번호 11자리를 숫자만 입력해 주세요')
            setIsPhonenumber(false)
        } else {
            setPhonenumberMessage('확인되었습니다.')
            setIsPhonenumber(true)
        }
    }
    
    //아이디 중복값 인증
    const onCheckId = (event) => {
        //입력값 남겨두는 함수
    event.preventDefault()

    console.log(user.id)
        dispatch(checkId(user.id))
        .then((response) => {
            if(response.payload.status === 200){
                history("/signin", {replace: true})
                alert("사용가능한 ID입니다.")
            }else{
                alert("사용 불가능한 ID입니다.")
            }
        })
        .catch((err) => {
            console.log("idcheck_err",err);
        })
    }

    //닉네임 중복값 인증
    const onCheckNickname = (event) => {
        //입력값 남겨두는 함수
    event.preventDefault()

    console.log(user.nickname)
        dispatch(checkNickname(user.nickname))
        .then((response) => {
            if(response.payload.status === 200){
                history("/signin", {replace: true})
                alert("사용가능한 닉네임입니다.")
            }else{
                alert("사용 불가능한 닉네임입니다.")
            }
        })
        .catch((err) => {
            console.log("nicknamecheck_err",err);
        })
    }

    //메인으로 가는 함수
    const onGoMain = (event) => {
        event.preventDefault();
        history("/");
    }

    //가입버튼 눌렀을 때 호출되는 함수
    const onSubmit = (event) => {

    //입력값 남겨두는 함수
    event.preventDefault()

    if((user.id === '' || user.name === '' || user.nickname === '' || user.password === '' || user.phonenumber === '')){
        alert('모든 정보를 입력해주세요');
        console.log(user);
    }else{
        // userInfo(UserSlice에 있음) => user
        dispatch(signup(user))
        .then((response) => {
            console.log("signin_response",response)
            if(response.payload.status === 200){
                history("/login", {replace: true})
                alert("회원가입 완료.")
            }else{
                history("/signin", {replace:true})
                alert("중복검사를 완료 후, 다시 시도해주세요.")
            }
            
          })
        console.log(user);
    }
    
  }

  //회원가입 폼
  return (
    <Container >

      <Form style={{ width:"40%", margin:"0 auto", top:"1em", position:"relative",padding:"1em", backgroundImage:`url(${userform_img})`, backgroundSize:"cover"}}>
        
        <LogoWrapper>
          <SingUpLogo src={signup_img}></SingUpLogo>
        </LogoWrapper>

        <FormGroup className='mb-3' controlId='formBasicId'>
            <Form.Label style={{marginLeft: "10%"}}>아이디</Form.Label>
            <FormGroup style={{display: "flex"}}>
                <Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name='id' type='id' placeholder='아이디' value={id} onChange={onChangeId}/>
                {id.length === 0 ? <Button style={{marginLeft:"1em"}} onClick={onCheckId} disabled variant='secondary'>중복검사</Button>
                 : <Button style={{marginLeft:"1em"}} onClick={onCheckId} variant='primary'>중복검사</Button>}
            </FormGroup>
            <FormGroup style={{marginLeft:"10%", marginTop:"3px"}}>
                {id.length > 0 && <span className={`message ${isId ? 'success' : 'error'}`}>{idMessage}</span>}
            </FormGroup>
        </FormGroup>

        <FormGroup className='mb-3' controlId='formBasicName'>
            <Form.Label style={{marginLeft: "10%"}}>이름</Form.Label>
            <Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name="name" type="text" placeholder="이름" value={name} onChange={onChangeName} />
        </FormGroup>

        <FormGroup className='mb-3' controlId='formBasicNickname'>
            <Form.Label style={{marginLeft: "10%"}}>별호</Form.Label>
            <FormGroup style={{display: "flex"}}>
                <Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name="nickname" type="text" placeholder="별호" value={nickname} onChange={onChangeNickname} />
                {nickname.length === 0 ? <Button style={{marginLeft:"1em"}} onClick={onCheckNickname} disabled variant='secondary'>중복검사</Button>
                : <Button style={{marginLeft:"1em"}} onClick={onCheckNickname} variant='primary'>중복검사</Button>}
            </FormGroup>
            <FormGroup style={{marginLeft:"10%", marginTop:"3px"}}>
                {nickname.length > 0 && <span className={`message ${isNickname ? 'success' : 'error'}`}>{nicknameMessage}</span>}
            </FormGroup>
        </FormGroup>

        <FormGroup className='mb-3' controlId='formBasicPassword'>
            <Form.Label  style={{marginLeft: "10%"}}>비밀번호</Form.Label>
            <Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name="password" type="password" placeholder="비밀번호" value={password} onChange={onChangePassword} />
            <FormGroup style={{marginLeft:"10%", marginTop:"3px"}}>
                {password.length > 0 && <span className={`message ${isPassword ? 'success' : 'error'}`}>{passwordMessage}</span>}
            </FormGroup>
        </FormGroup>

        <FormGroup className='mb-3' controlId='formBasicConfirmPassword'>
            <Form.Label style={{marginLeft: "10%"}}>비밀번호 확인</Form.Label>
            <Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name="confirmPassword" type="password" placeholder="비밀번호 확인" value={confirmPassword} onChange={onChangeConfirmPassword} />
            <FormGroup style={{marginLeft:"10%", marginTop:"3px"}}>
                {confirmPassword.length > 0 && <span className={`message ${isConfirmPassword ? 'success' : 'error'}`}>{confirmPasswordMessage}</span>}
            </FormGroup>
        </FormGroup>

        <FormGroup  className='mb-3' controlId='formBasicPhoneNumber'>
            <Form.Label style={{marginLeft: "10%"}}>휴대폰 번호</Form.Label>
            <Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name="phonenumber" type="text" placeholder="휴대폰 번호" value={phonenumber} onChange={onChangePhoneNumber}/>
            <FormGroup style={{marginLeft:"10%", marginTop:"3px"}}>
                {phonenumber.length > 0 && <span className={`message ${isPhonenumber ? 'success' : 'error'}`}>{phonenumberMessage}</span>}
            </FormGroup>
        </FormGroup>

        <FormGroup style={{width:"80%", display:"flex", margin:"0 auto"}} >
          <Button style={{marginBottom: "1em", width: "50%", backgroundColor:"#8C4D25", border:"0"}} type="submit" onClick={onSubmit} variant="primary">계정 생성하기</Button>
          <Button style={{marginBottom: "1em", width: "50%", backgroundColor:"grey", marginLeft:"1em"}} variant="secondary" onClick={onGoMain}>메인으로</Button>
        </FormGroup>

      </Form>
    </Container>
  );
}
export default Signin;