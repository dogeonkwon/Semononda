import React from 'react'
import {Button, Form, FormGroup, FormLabel} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import { useDispatch, useSelector } from 'react-redux';
import {Link, useNavigate}from 'react-router-dom'
import styled from "styled-components";
import {handleShow} from "./Example"

//이미지 파일
import infobase from "../../../assets/images/dark_base.PNG"
import userform_img from "../../../assets/images/userform_img.png"
import mypage_img from "../../../assets/images/mypage_img.png"
import human from "../../../assets/images/human.png"

//메인페이지 배경화면 Container

const Container = styled.div`
    display: block;
    position: relative;
    width: 100%;  
    height: 100%;
    max-width: 100%;
    max-height: 100%;
    background: center;
    background-color: black;
    background-repeat: no-repeat;
    background-image: url(${infobase});
    background-size: cover;`


//로고 영역
const LogoWrapper = styled.div`
  display: flex;
  flex: 1;
  justify-content: center;
  align-items: center;
  width: 40%;
  height: 40%;
  margin: 0 auto;
  margin-bottom: 2em;
  margin-top: 0;
  `
//로고 이미지
const LoginLogo = styled.img`
  width: 100%;
  height: 100%;
  flex: 1;
  margin-bottom: 10px;
  margin-top: 3em;
  text-align: top;`

//마이페이지 박스
const IdBox = styled.div`
  border: solid 1px;
  padding: 1em;
  display: flex;
`
//마이페이지 라벨
const TitleLabel = styled.label`
  font-weight: bold;
`
//프로필 이미지 영역
const ProfileImgArea = styled.div`
  background-color: yellow;
  width: 30%;
  height: auto;
`
//프로필 이미지
const ProfileImg = styled.img`
  width: 100%;
  height: 100%;
`
//프로필 정보 영역
const ProfileInfoArea = styled.div`
  background-color: red;
  width: 70%;
  padding: 1em;
`
//프로필 닉네임, 이름 영역
const ProfileNicknameNameArea = styled.div`
  display: flex;
`

//프로필 세부 영역
const ProfileDetialInfo = styled.div`
  width: 50%;
  display: block;
`
//링크
const StyledLink = styled(Link)`
  text-decoration: none;

  &:focus, &:hover, &:visited, &:link, &:active {
    text-decoration: none;
}
`

function MyPage() {
  
  let user_info = useSelector(state => state.user.user);
  console.log("user_info",user_info)

  const dispatch = useDispatch();
  const history = useNavigate();
  
  //로그인 버튼 누르면 실행되는 함수
  const onSubmit = (e) => {
    e.preventDefault();
    handleShow();
  }

  return (
    <Container>
      <Form style={{width: "50%", heigth:"100%", textalign:"center",padding:"1em", backgroundImage:`url(${userform_img})`, backgroundSize:"cover", margin: "0 auto", position:"relative", top:"4%"}}>
        <LogoWrapper>
          <LoginLogo src={mypage_img}></LoginLogo>
        </LogoWrapper>
        <IdBox>
        <ProfileImgArea>
          <ProfileImg  src={human}/>
        </ProfileImgArea>
        <ProfileInfoArea>

        <FormGroup className='mb-3'>
            <TitleLabel> 아이디</TitleLabel>
            <Form.Control style={{width: "100%", textalign:"center"}}>한산</Form.Control>
        </FormGroup>
        <FormGroup className='mb-3'>
          <ProfileNicknameNameArea>
            <ProfileDetialInfo>
            <TitleLabel> 별호</TitleLabel>
            <Form.Control style={{width: "100%", textalign:"center"}}>충무공</Form.Control>
            </ProfileDetialInfo>
            <ProfileDetialInfo>
            <TitleLabel> 이름</TitleLabel>
            <Form.Control style={{width: "100%", textalign:"center"}}>이순신</Form.Control>
            </ProfileDetialInfo>
          </ProfileNicknameNameArea>
        </FormGroup>
        <FormGroup className='mb-3'>
            <TitleLabel> 전화번호</TitleLabel>
            <Form.Control style={{width: "100%", height:"fit-content", textalign:"center"}}>010-1234-1234</Form.Control>
        </FormGroup>
        <FormGroup>
            <TitleLabel> 한줄 소개 </TitleLabel>
            <Form.Control style={{width: "100%", height:"fit-content", textalign:"center"}}>마! 내가 이순신이다</Form.Control>
        </FormGroup>
        </ProfileInfoArea>
        </IdBox>
        <FormGroup style={{marginTop: "3em", marginBottom: "3em"}}>
            <Button style={{marginBottom: "1em", width: "100%", backgroundColor:"#8C4D25"}} type="submit" >회원정보 수정</Button>
            <StyledLink to={"/signin"}><Button style={{marginBottom: "1em", width: "100%", backgroundColor:"#CC8960"}} onClick={onSubmit}>비밀번호 변경</Button></StyledLink>
        </FormGroup>
        
      </Form>
    </Container>
    );
  }

export default MyPage;