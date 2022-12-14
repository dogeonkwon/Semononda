import React, { useState, useEffect } from "react";
import { Button, Form, FormGroup, FormLabel } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";
import { Link, useNavigate } from "react-router-dom";
import styled from "styled-components";
import NavBar from "../../../common/navbar/NavBar";
import Table from "react-bootstrap/Table";
import UserPagination from "./UserPagination";

//이미지 파일
import light_base from "../../../assets/images/light_base.png";
import Statistics_form_img from "../../../assets/images/Statistics_form_img.png";
import scroll_green from "../../../assets/images/scroll_green.png";

//yu
import "@grapecity/wijmo.styles/wijmo.css";
import * as wjChart from "@grapecity/wijmo.react.chart";
import * as wjChartAnimate from "@grapecity/wijmo.react.chart.animation";
import Collapse from "./Collapse";

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
  background-size: cover;
  padding-top: 10%;
  padding-bottom: 10%;
`;
//yu
const Base = styled.div`
  display: block;
  position: relative;
  height: 120%;
  background: center;
  background-repeat: no-repeat;
  background-image: url(${scroll_green});
  background-size: contain;
  
`;

const Container1 = styled.div`
  width: 45%;
  margin: 0px 27.5%;
  padding: 53px 0px;
  height: 100%;
  overflow: hidden; // 선을 넘어간 이미지들은 숨겨줍니다.
  font-family: JsaHON;
  display: block;
`;

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
`;
//로고 이미지
const LoginLogo = styled.img`
  width: 100%;
  height: 100%;
  flex: 1;
  margin-bottom: 10px;
  margin-top: 3em;
  text-align: top;
`;

//링크
const StyledLink = styled(Link)`
  text-decoration: none;

  &:focus,
  &:hover,
  &:visited,
  &:link,
  &:active {
    text-decoration: none;
  }
`;
//yu
const StatisticsRoomBase = styled.div`
  display: block;
  position: relative;
  height: 120%;
  width: 65%;
  margin: 0px 17.5%;
  padding: 100px 100px;

  background-image: url(${Statistics_form_img});
  background-size: contain;
`;

//header
const HeaderContainer = styled.div`
  display: flex;
  margin: 0 auto;
  font-family: JsaHON;
  width: 30%;
  height: 4rem;
  padding: 2rem;
  justify-content: center;
`;

function Statistics() {
  return (
    <Container>
      <NavBar />
      <Base>
      
        <div>
          <Collapse />
        </div>
      
      </Base>
    </Container>
  );
}

export default Statistics;
