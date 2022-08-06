import React,{useCallback, useState} from 'react'
import {Button, Form, FormGroup, FormLabel} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import { useSelector } from 'react-redux';
import {useNavigate}from 'react-router-dom'
import styled from "styled-components";
import '../../../common/modal/Modal.css'
//이미지 파일
import infobase from "../../../assets/images/dark_base.PNG";
import userform_img from "../../../assets/images/userform_img.png";
import mypage_img from "../../../assets/images/mypage_img.png";
import human from "../../../assets/images/human.png";

//컴포넌트
import Modal from "../../../common/modal/Modal";

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

function MyPage() {
  
  let user_info = useSelector(state => state.user.user);
  console.log("user_info",user_info)

  //모달)모달관련 state
  const [isOpenModal, setOpenModal] = useState(false);
  const [password, setPassword] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [checkNewPassword, setCheckNewPassword] = useState("");
  
  //모달)open 동작
  const onClickToggleModal = useCallback(() => {
    setOpenModal(!isOpenModal);
  },[isOpenModal]);

  //
  //모달) 비밀번호 변경 누르면 실행하는 동작
  const onChangePassword = (e) => {
    e.preventDefault();
    alert("준비중입니다.")
  }
  //모달) 닫기 버튼 누르면 실행하는 동작
  const onCloseModal = (e) => {
    e.preventDefault();
    setOpenModal(false);
  }
  //로컬스토리지 
  let loginInfoString = window.localStorage.getItem("login_user");
  console.log('loginInfoString', loginInfoString)
  let loginInfo = JSON.parse(loginInfoString);

  //전화번호 파싱함수
  function parsePhonenumber(phonenumber){
    let resultNumber = [];
    let first = "";
    let second = "";
    let third = "";
    if(phonenumber.length === 11){
        first = phonenumber.substring(0,3);
        second = phonenumber.substring(3,7);
        third = phonenumber.substring(7,11);      
    }
    resultNumber.push(first);
    resultNumber.push(second);
    resultNumber.push(third);

    console.log(phonenumber);
    console.log(resultNumber);
    return resultNumber.filter((val) => val).join("-");
  }

  //파싱된 전화번호
  const parsedPhonenumber = parsePhonenumber(loginInfo.phonenumber);

  const history = useNavigate();
  


  //회원정보 수정 버튼 누르면 실행되는 함수
  const onEditPage = (e) => {
    e.preventDefault();
    history("/editprofile");
  }

  return (
    <Container>
      <Form style={{width: "50%", heigth:"fit-content", textalign:"center",padding:"1em", backgroundImage:`url(${userform_img})`, backgroundSize:"cover", margin: "0 auto", position:"relative", top:"4%"}}>
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
            <FormLabel style={{width: "100%", textalign:"center"}}>{loginInfo.id}</FormLabel>
        </FormGroup>
        <FormGroup className='mb-3'>
          <ProfileNicknameNameArea>
            <ProfileDetialInfo>
            <TitleLabel> 별호</TitleLabel>
            <FormLabel style={{width: "100%", textalign:"center"}}>{loginInfo.nickname}</FormLabel>
            </ProfileDetialInfo>
            <ProfileDetialInfo>
            <TitleLabel> 이름</TitleLabel>
            <FormLabel style={{width: "100%", textalign:"center"}}>{loginInfo.name}</FormLabel>
            </ProfileDetialInfo>
          </ProfileNicknameNameArea>
        </FormGroup>
        <FormGroup className='mb-3'>
            <TitleLabel> 전화번호</TitleLabel>
            <FormLabel style={{width: "100%", height:"fit-content", textalign:"center"}}>{parsedPhonenumber}</FormLabel>
        </FormGroup>
        <FormGroup>
            <TitleLabel> 한줄 소개 </TitleLabel>
            <FormLabel style={{width: "100%", height:"fit-content", textalign:"center"}}>{loginInfo.description}</FormLabel>
        </FormGroup>
        </ProfileInfoArea>
        </IdBox>
        <FormGroup style={{marginTop: "3em", marginBottom: "3em"}}>
            <Button style={{marginBottom: "3em", width: "100%", backgroundColor:"#8C4D25", border:"0"}} onClick={onEditPage}>회원정보 수정</Button>
            <Button style={{marginBottom: "1em", width: "100%", backgroundColor:"#CC8960",border:"0"}} onClick={onClickToggleModal}>비밀번호 변경</Button>
        </FormGroup>
        
      {isOpenModal&& (
      <Modal onClickToggleModal={onClickToggleModal}>
        <FormGroup className='mb-3'>
            <FormLabel style={{float:"left"}}> 현재 비밀번호 </FormLabel>
            <Form.Control style={{width: "100%", textalign:"center"}} type="password"/>
        </FormGroup>
        <FormGroup className='mb-3'>
            <FormLabel style={{float:"left"}}> 새로운 비밀번호</FormLabel>
            <Form.Control style={{width: "100%", textalign:"center"}} type="password"/>
        </FormGroup>
        <FormGroup className='mb-3'>
            <FormLabel style={{float:"left"}}> 새로운 비밀번호 확인</FormLabel>
            <Form.Control style={{width: "100%", textalign:"center"}} type="password"/>
        </FormGroup>
        <FormGroup style={{marginTop: "3em", marginBottom: "3em"}}>
            <Button style={{marginBottom: "1em",  width: "100%", backgroundColor:"#8C4D25", border:"0"}} onClick={onChangePassword}>비밀번호 변경</Button>
            <Button style={{marginBottom: "1em",  width: "100%", backgroundColor:"grey", border:"0"}} onClick={onCloseModal}>취소</Button>
        </FormGroup>
      </Modal>
      )}
      </Form>
    </Container>
    );
  }

export default MyPage;