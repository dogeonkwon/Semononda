import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';
import styled from "styled-components";
import logo from "../../../assets/images/logo.png"
import NavBar from "../../../common/navbar/NavBar";
import './Rank.css';
import Pagination from "./Pagination";
import Modal from "../../../common/modal/Modal";

const Layout = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 auto;
  background-size: cover;
`;


function Rank() {

	const [posts, setPosts] = useState([]);
	const [limit, setLimit] = useState(6);
	const [page, setPage] = useState(1);
	const offset = (page - 1) * limit;


	// 모달 관련
	const [isOpenModal, setOpenModal] = useState(false);


	//모달)open 동작
	const onClickToggleModal = useCallback(() => {
	setOpenModal(!isOpenModal);
	},[isOpenModal]);

	//모달) 닫기 버튼 누르면 실행하는 동작
	const onCloseModal = (e) => {
		e.preventDefault();
		setOpenModal(false);
	}


	useEffect(() => {
	  fetch("https://jsonplaceholder.typicode.com/posts")
		.then((res) => res.json())
		.then((data) => setPosts(data));
	}, []);

	return (
		<div className="rank-base">
			<NavBar />

			{/* 방 생성 화면(메인) */}
			<main>
				{/* <div className="room_container">
					<div className="room_items">
						<RoomItem 
						src = {logo}
						text = "랭크모드"
						label = 'Adventure'
						path='/custom'
						pesonnel = "1/7"
						title = "너만 오면 고"
						/>
					</div>
				</div> */}
			</main>
				
			{/* 페이지네이션 */}
			<footer>
				<Pagination
				total={posts.length}
				limit={limit}
				page={page}
				setPage={setPage}
				/>
				<div>
					<input />
					<button>검색</button>
					<button>
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
					</button>
				</div>
			</footer>
		</div>
	);
}
export default Rank;