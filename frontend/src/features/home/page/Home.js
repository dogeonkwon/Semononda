import React from "react";
import 'bootstrap/dist/css/bootstrap.css';
import styled from "styled-components";
import {Link} from "react-router-dom";

//메인페이지 배경화면 파일
const homeImgUrl = "homebase.png";

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
    background-image: url(${homeImgUrl});
    background-size: cover;`

//Container 이분할
const Section = styled.div`
    width: 100%;
    height: 50%;
    float: left;`

//로그인 버튼(임시)
const LoginButton = styled.button`
    position: absolute;
    right: 0px;
    bottom: 0px;`

//회원가입 버튼(임시)
const JoinButton = styled.button`
    position: absolute;
    right: 0px;
    bottom: 2em;`

//로고 영역
const LogoWrapper = styled.div`
  display: flex;
  flex: 1;
  justify-content: center;
  align-items: center;
  width: fit-content;
  height: fit-content;
  margin: 0 auto;
  `
//로고 세부 영역
const SecondLogoWrapper = styled.div`
  align-self: self-start;
  margin-top: 3em;`

//로고 이미지
const Logo = styled.img`
  width: 100%;
  height: 100%;
  flex: 1;
  margin-bottom: 10px;
  text-align: top;`


//논쟁 시작 버튼 영역
const ArguementGroup = styled.div`
  display: flex;
  margin: 0 auto;
  width: 40%;
  justify-content: space-between;
  position: absolute;
  bottom: 3em;
  left: 30%;
`

//공식 경연 버튼
const OfficialButton = styled.button`
`
//자유 경연 버튼
const FreeButton = styled.button`
`



function home() {
    
    return (
        
            <Container>

                <Section>
                <LogoWrapper>
                    <SecondLogoWrapper>
                        <Logo src="homelogo.png"></Logo>
                    </SecondLogoWrapper>
                </LogoWrapper>
                </Section>

                <Section>
                <ArguementGroup>
                    <OfficialButton>공식 경연</OfficialButton>
                    <FreeButton>자유 경연</FreeButton>
                </ArguementGroup>
                </Section>

                <LoginButton><Link to="/login">로그인테스트</Link></LoginButton>
                <JoinButton><Link to="/signin">회원가입테스트</Link></JoinButton>

            </Container>
    );
}

export default home;