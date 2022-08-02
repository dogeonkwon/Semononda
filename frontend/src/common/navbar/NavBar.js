import React, { useState } from "react";
import { Link } from "react-router-dom";
import './NavBar.css';
import { CgProfile } from "react-icons/cg";
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
import ProgressBar from 'react-bootstrap/ProgressBar';

function NavBar() {

  const Logo = styled.img`
    width: 11vh;
    height: 11vh;
  `

  return (
    <>
      {[false].map((expand) => (
        <Navbar key={expand} bg="white" expand={expand} className="navbar mb-3">
          <Container fluid>
            <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-${expand}`} />
              <Link to="/rank"><button className="formula">공식경연</button></Link>  
              <Link to="/"><Logo className="logo" src={logo} /></Link>
              <Link to="/free"><button className="free">자유경연</button></Link>
              <Link to="/myPage"><CgProfile className="profile" color="black" size="50"></CgProfile></Link>
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
                  <Nav.Link href="/rank"><RiIcons.RiArrowUpDownLine />  신하 순위</Nav.Link>
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