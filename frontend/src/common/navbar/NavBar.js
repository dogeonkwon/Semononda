import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import './NavBar.css';
//import { CgProfile } from "react-icons/cg";
import logo from '../../assets/images/logo.png';
import styled from "styled-components";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Offcanvas from 'react-bootstrap/Offcanvas';
import * as BiIcons from 'react-icons/bi';
import * as RiIcons from 'react-icons/ri';
import * as GoIcons from 'react-icons/go';
import * as IoIcons from 'react-icons/io';
import * as GiIcons from 'react-icons/gi';
import ProgressBar from 'react-bootstrap/ProgressBar';
import { getToken, deleteToken } from '../../common/api/JWT-common';
import { Dropdown } from "react-bootstrap";

const FormulaButton1 = styled.button`
  font-family: JSArirangHON;
    position: relative;
    border: none;
    min-width: 200px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        rgb(70, 70, 185) 0%,
        rgb(40, 40, 220) 100%
        );
        border-radius: 1000px;
    color: rgb(255, 255, 255);
    cursor: pointer;
    box-shadow: 12px 12px 24px rgb(175, 175, 235);
    font-weight: 500;
    transition: 0.3s;
    font-size: 40px;
`
const FormulaButton2 = styled.button`
font-family: JSArirangHON;
    position: relative;
    border: none;
    min-width: 200px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        rgb(143, 143, 152) 0%,
        rgb(59, 54, 61) 100%
        );
        border-radius: 1000px;
    color: rgb(255, 255, 255);
    cursor: pointer;
    box-shadow: 12px 12px 24px rgb(175, 175, 235);
    font-weight: 500;
    transition: 0.3s;
    font-size: 40px;
`
const CustomButton1 = styled.button`
font-family: JSArirangHON;
    position: relative;
    border: none;
    min-width: 200px;
    min-height: 50px;
    background: linear-gradient(
      90deg,
      rgb(65, 165, 65) 0%,
      rgb(50, 135, 45) 100%
      );
      border-radius: 1000px;
      color: rgb(255, 255, 255);
      cursor: pointer;
      box-shadow: 12px 12px 24px rgb(180, 235, 170);
      font-weight: 500;
      transition: 0.3s;
      font-size: 40px;
`
const CustomButton2 = styled.button`
font-family: JSArirangHON;
    position: relative;
    border: none;
    min-width: 200px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        rgb(143, 143, 152) 0%,
        rgb(59, 54, 61) 100%
        );
        border-radius: 1000px;
    color: rgb(255, 255, 255);
    cursor: pointer;
    box-shadow: 12px 12px 24px rgb(175, 175, 235);
    font-weight: 500;
    transition: 0.3s;
    font-size: 40px;
`

function NavBar(props) {

  const [scrollPosition, setScrollPosition] = useState(window.scrollY);

  const updateScroll = () => {
      const back = document.getElementById("Navbar");
      const homeheight = document.getElementById("Container").clientHeight;
      const opcity = 0 + (scrollPosition/homeheight)*5;
      setScrollPosition(window.scrollY || document.documentElement.scrollTop);
      back.style.backgroundColor = `rgb(255,255,255,${opcity})`;

  }

  useEffect(()=>{
      window.addEventListener('scroll', updateScroll);
  });


  const history = useNavigate();
  
  //로컬스토리지 
  let loginInfoString = window.localStorage.getItem("login_user");
  let loginInfo = JSON.parse(loginInfoString);

  
  const token = getToken();
  useEffect(()=>{
    console.log(token);
  },[token]);
  
  const Logo = styled.img`
    width: 11vh;
    height: 11vh;
  `
  const logoutHandler = () => {
    deleteToken();
    window.localStorage.removeItem("login_user");
    history('/');
  }

  const myPageHandler = () => {
    history('/profile');
  }
  return (
    <>
      {[false].map((expand) => (
        <Navbar id="Navbar" key={expand} expand={expand} className="navbar mb-3" style={{width:"100%", textAlign:"center", position:"fixed", top:"0", zIndex:"2"}}>
          <Container style={{alignItems:"center"}}>
          <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-${expand}`}>
              <GiIcons.GiHamburgerMenu color="ghostwhite" size="30px"/>
            </Navbar.Toggle>
            {props.isHome ?  
            ( <Link to="/"><Logo className="logo" src={logo} /></Link> )
            :
            (
              <div style={{display:"flex", alignItems:"center", width:"60%", justifyContent:"space-between"}}>
              {props.isCustom ?
              <Link to="/rank"><FormulaButton2 className="formula">공식경연</FormulaButton2></Link> 
              : <Link to="/rank"><FormulaButton1 className="formula">공식경연</FormulaButton1></Link>  
              }
              <Link to="/"><Logo className="logo" src={logo} /></Link>
              {props.isRank ?
              <Link to="/custom"><CustomButton2 className="custom">자유경연</CustomButton2></Link>
              : <Link to="/custom"><CustomButton1 className="custom">자유경연</CustomButton1></Link>
              }
              </div>
            )
            }
              {token ?
               (
                  <Dropdown align={"start"}>   
                  {/* <CgProfile className="profile" color="black" size="50" onClick={logoutHandler}></CgProfile> */}
                    <Dropdown.Toggle variant="Secondary" style={{backgroundColor: "#4A4A4A", color: "white", fontWeight:"bold"}}>
                      {loginInfo.nickname}
                    </Dropdown.Toggle>
                    <Dropdown.Menu variant="dark" style={{float:"right", textAlign:"center"}}>
                     <Dropdown.Item onClick={logoutHandler}>로그아웃</Dropdown.Item>
                     <Dropdown.Divider/>
                     <Dropdown.Item onClick={myPageHandler}>마이페이지</Dropdown.Item>
                    </Dropdown.Menu>
                  </Dropdown>
               ):
               (<Link to="/login"><button className="btn-login">로그인</button></Link>)
              }
              {/* <Link to="/myPage"><CgProfile className="profile" color="black" size="50"></CgProfile></Link> */}
              
            <Navbar.Offcanvas
              id={`offcanvasNavbar-expand-${expand}`}
              aria-labelledby={`offcanvasNavbarLabel-expand-${expand}`}
              placement="start"
            >
              
              <Offcanvas.Header closeButton>
                <Offcanvas.Title id={`offcanvasNavbarLabel-expand-${expand}`}>
                <Link to="/"><Logo className="logoImg logo justify-content-center" src={logo} /></Link>
                </Offcanvas.Title>
              </Offcanvas.Header>
              <ProgressBar variant="secondary" now={100} className="m-3"/>
              <Offcanvas.Body>
                <Nav className="side-text justify-content-center flex-grow-1 pe-3">
                  <Nav.Link href="/news"><BiIcons.BiNews />  소식</Nav.Link>
                  <Nav.Link href="/userrank"><RiIcons.RiArrowUpDownLine />  신하 순위</Nav.Link>
                  <Nav.Link href="/statistics"><GoIcons.GoGraph />  주제별 통계</Nav.Link>
                  <Nav.Link href="/gossip"><GoIcons.GoCommentDiscussion />  저잣거리</Nav.Link>
                  <Nav.Link href="/help"><IoIcons.IoMdHelpCircle />  도움말</Nav.Link>
                </Nav>
              </Offcanvas.Body>
            </Navbar.Offcanvas>
          </Container>
        </Navbar>
      ))}
    </>
  );
}


export default NavBar;