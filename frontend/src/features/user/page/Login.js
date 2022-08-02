import React, {useState} from 'react'
import {Button, Form, FormGroup, FormLabel} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import { useDispatch } from 'react-redux';
import {useNavigate}from 'react-router-dom'
import { toast } from 'react-toastify';
import {login} from '../UserSlice';
import styled from "styled-components";
import homebase from "../../../assets/images/homebase.png"
import userform_img from "../../../assets/images/userform_img.png"
import login_img from "../../../assets/images/login_img.png"


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
    background-image: url(${homebase});
    background-size: cover;`

//로고 영역
const LogoWrapper = styled.div`
  display: flex;
  flex: 1;
  justify-content: center;
  align-items: center;
  width: 20%;
  height: 20%;
  margin: 0 auto;
  margin-bottom: 2em;
  `
//로고 이미지
const LoginLogo = styled.img`
  width: 100%;
  height: 100%;
  flex: 1;
  margin-bottom: 10px;
  margin-top: 3em;
  text-align: top;`

function Login() {
  const dispatch = useDispatch();
  const history = useNavigate();

  //id
  const [userId, setId] = useState("");
  //password
  const [password, setPassword] = useState(""); 
  
  //Idhandler
  const onIdHandler = (event) => {
    setId(event.currentTarget.value);
  }

  //Passwordhandler
  const onPasswordHandler = (event) => {
    setPassword(event.currentTarget.value);
  }

  //로그인 버튼 누르면 실행되는 함수
  const onSubmit = (e) => {
    console.log(e)
    e.preventDefault();
    const data = {
      userId,
      password,
    };
    dispatch(login(data))
    
    .then(() => {
        history("/login", {replace: true})
      })
      .catch((err) => {
        if (err.status === 400) {
          toast.error('😥 입력하신 정보를 다시 확인해주세요');
        } else if (err.status === 409) {
          toast.error('😥 이미 로그인된 사용자입니다');
        } else if (err.status === 401) {
          toast.error('😥 아이디와 비밀번호를 다시 확인해주세요');
          history.push('/login');
        } else if (err.status === 500) {
          history.push('/error');
        }
      });
  }

  return (
    <Container>
      <Form style={{width: "50%", textalign:"center",padding:"1em", backgroundImage:`url(${userform_img})`, backgroundSize:"cover", margin: "0 auto", position:"relative", top:"15%"}}>
        <LogoWrapper>
          <LoginLogo src={login_img}></LoginLogo>
        </LogoWrapper>
        <FormGroup className='mb-3'>
            <FormLabel style={{marginLeft: "25%"}}> 아이디</FormLabel>
            <Form.Control style={{width: "50%", textalign:"center", margin:"0 auto"}} name="userId" type="id" placeholder="아이디" value={userId} onChange={onIdHandler}/>
        </FormGroup>
        <FormGroup className='mb-3'>
            <FormLabel style={{marginLeft: "25%"}}> 비밀번호</FormLabel>
            <Form.Control style={{width: "50%", textalign:"center", margin:"0 auto"}} name="password" type="password" placeholder="비밀번호" value={password} onChange={onPasswordHandler}/>
        </FormGroup>
        <FormGroup style={{marginTop: "3em", marginBottom: "3em"}}>
            <Button style={{marginBottom: "1em", marginLeft: "25%", width: "50%", backgroundColor:"#8C4D25"}} type="submit" onClick={onSubmit}>로그인</Button>
            <Button style={{marginBottom: "1em", marginLeft: "25%", width: "50%", backgroundColor:"#CC8960"}} type="submit" onClick={onSubmit}>회원가입</Button>
        </FormGroup>
      </Form>
    </Container>
    );
  }

export default Login;