import React from 'react'
import {Form} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import styled from "styled-components";
import NavBar from '../../../common/navbar/NavBar';

//이미지 파일
import light_base from "../../../assets/images/light_base.png"
import Statistics_form_img from "../../../assets/images/Statistics_form_img.png"

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
    background-image: url(${light_base});
    background-size: cover;
    padding-top:10%`

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

const News = () => {
    
    return (
      <Container id='Container'>
        <NavBar/>
        <Form style={{width: "50%", textalign:"center",padding:"0.5em", backgroundImage:`url(${Statistics_form_img})`, backgroundSize:"cover", margin: "0 auto", position:"relative", top:"15%"}}>
        <LogoWrapper>
            <h1>소식</h1>
            </LogoWrapper>
        </Form>
      </Container>
      );
    }
  
export default News;