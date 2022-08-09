import React, {useState} from 'react'
import {Button, Form, FormGroup, FormLabel} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import {Link, useNavigate}from 'react-router-dom'
import styled from "styled-components";


//merge conflict test
//이미지 파일
import light_base from "../../../assets/images/light_base.png"
import Statistics_form_img from "../../../assets/images/Statistics_form_img.png"
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
    background-image: url(${light_base});
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

//링크
const StyledLink = styled(Link)`
  text-decoration: none;

  &:focus, &:hover, &:visited, &:link, &:active {
    text-decoration: none;
}
`



const News = () => {
    
    return (
      <Container>
        <Form style={{width: "50%", textalign:"center",padding:"0.5em", backgroundImage:`url(${Statistics_form_img})`, backgroundSize:"cover", margin: "0 auto", position:"relative", top:"15%"}}>
        <LogoWrapper>
            <h1>저잣거리</h1>
            </LogoWrapper>
        </Form>
      </Container>
      );
    }
  
export default News;