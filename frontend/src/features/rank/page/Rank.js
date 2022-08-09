import React, { useState, useEffect, useCallback } from "react";
import styled from "styled-components";
import love from "../../../assets/images/love.png"
import NavBar from "../../../common/navbar/NavBar";
import './Rank.css';
import Pagination from "./Pagination";
import {Button, Form, FormGroup} from 'react-bootstrap';
import Modal from "../../../common/modal/Modal";
import '../../../common/modal/Modal.css'
import { useDispatch } from 'react-redux';
import { useNavigate}from 'react-router-dom'
import { roomcreate } from '../RankSlice';

import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

// 드롭박스
const OPTIONS = [
	{ value: '1', name: '개발자' },
	{ value: '2', name: '극과극' },
	{ value: '3', name: '교육' },
	{ value: '4', name: '음식' },
	{ value: '5', name: '연애' },
	{ value: '6', name: '일상생활' },
	{ value: '7', name: 'MBTI' },
];


const Select = styled.select`
	// margin: 0;
	// min-width: 0;
	// display: block;
	// width: 100%;
	// padding: 8px 8px;
	// font-size: inherit;
	// line-height: inherit;
	// border: 1px solid;
	// border-radius: 4px;
	// color: inherit;
	// background-color: transparent;
`;

const SelectBox = (props) => {
	const handleChange = (e) => {
		// event handler
		console.log(e.target.value);
	};

	return (
		<Select onChange={handleChange}>
			{props.options.map((option) => (
				<option
					key={option.value}
					value={option.value}
					defaultValue={props.defaultValue === option.value}
				>
					{option.name}
				</option>
			))}
		</Select>
	);
};


function Rank() {

	const dispatch = useDispatch();
    const history = useNavigate();

	const [isRank, setIsRank] = useState(true);

	// 페이지네이션
	const [posts, setPosts] = useState([]);
	const [limit, setLimit] = useState(6);
	const [page, setPage] = useState(1);
	const offset = (page - 1) * limit;


	//오류메시지 상태저장
	const [roomMessage, setRoomMessage] = useState('')


	// 유효성 검사 상태 저장
	const [isRoom, setIsRoom] = useState(false)


	//서버로 전달할 room객체
	const [room, setRoom] = useState({
		normal : "True",
		title : "",
		gameCategoriesUid: "",
		roomAdminUserUid : "20",	// (roomAdminUserUid가 변경 되면 => oginInfo.id)
		conferenceRoomUrl : "www.naver.com",
		gameCategoryTopicsUid : "1",
		})

	//방 제목
    const onChangeTitle = (e) => {
        //한글, 영어, 숫자 사용가능
        const nicknameRegex = /([ㄱ-ㅎ|가-힣|0-9|a-z|A-Z])/
        const { name, value } = e.target;
        setRoom({
            ...room,
            [name]: value
        });
        //30자 이내로 입력가능
        if(!nicknameRegex.test(room.nickname) || e.target.value.length >30) {
            setRoomMessage('30자 이내로 입력 가능합니다.')
            setIsRoom(false)
        } else {
		}
	}

    //대분류(카테고리)
    const onChangeGameCategoriesUid = (e) => {
        const { name, value } = e.target;
        setRoom({
            ...room,
            [name]: value
        });
    }


    //방 생성 눌렀을 때 호출되는 함수
    const onSubmit = (event) => {

    //입력값 남겨두는 함수
    event.preventDefault()

    if((room.title === '')){
        alert('모든 정보를 입력해주세요');
        console.log(room);
    }else{
        // userInfo(UserSlice에 있음) => room
        dispatch(roomcreate(room))
        .then((response) => {
            console.log("create_response",response)
            if(response.payload.status === 200){
                history("/rank", {replace: true})
				console.log('된다', room);
            }else{
                history("/custom", {replace:true})
				console.log('안된다', room);
            }
            
		})
		console.log(room);
    }
  }

	//로컬스토리지 
	let roomInfoString = window.localStorage.getItem("roomAdminUserUid");
	console.log('roomInfoString', roomInfoString)	// 이거 왜 안나오지...
	let roomInfo = JSON.parse(roomInfoString);


	//room 객체 바인딩
	const { normal, gameCategoriesUid, roomAdminUserUid, title } = room;


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
		<div id="Container" className="rank-base">
		<NavBar isRank={isRank}/>
			<div className="layout container">
			{/* 방 생성 화면(메인) */}
			<main>
				<div className="room_items">
					<Row xs={1} md={2} className="g-4">
						{Array.from({ length: 6 }).map((_, idx) => (
							<Col>
							<div className="room_item">
								<img src={love} style={{width: "30%"}} />
								<div className="room_button">
									<button>방 제목 : </button>	{/* {roomInfo.title} */}
									{/* <button onChange={handleDropProduct}>
										{CATEGORY_DATA.map(el => {
											return <option key={el.id}>{el.value}</option>;
										})}
									</button>	 */}
									{/* {roomInfo.gameCategoriesUid} */}

									{/* 드롭박스 2 */}
									{/* <button onClick={e => setDropdownVisibility(!dropdownVisibility)}>
										{
											dropdownVisibility
												? 'Close'
												: '카테고리'
										}
									</button>
									<Dropdown visibility={dropdownVisibility}>
										<ul>
											<li>개발자</li>
											<li>극과극</li>
											<li>교육</li>
											<li>음식</li>
											<li>연애</li>
											<li>일상생활</li>
											<li>MBTI</li>
										</ul>
									</Dropdown> */}


									<button>카테고리 : </button>
									<button>방장 : </button> {/* {roomInfo.roomAdminUserUid} */}
									<button>입장</button>
								</div>
							</div>
							</Col>
						))}
					</Row>
				</div>
			</main>
				
			{/* 하단 */}
			<footer>
				{/* 페이지네이션 */}
				<Pagination
				total={posts.length}
				limit={limit}
				page={page}
				setPage={setPage}
				/>
				{/* 검색 및 방생성 */}
				<div className="bottom">
					{/* 검색 */}
					<div className="search">
					<input value="방이름을 입력해주세요."/>
					<button>검색</button>
					{/* 방생성 */}
					</div>
					<Button className="create_room" onClick={onClickToggleModal}>방 생성</Button>
					{isOpenModal&& (
						<Modal onClickToggleModal={onClickToggleModal}>
							<FormGroup className='mb-3' controlId='formBasicTitle'>
								<Form.Label style={{marginLeft: "10%"}}>방 제목</Form.Label>
								<Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name='title' type='text' placeholder='방 제목' value={title} onChange={onChangeTitle}/>
							</FormGroup>

							<FormGroup className='mb-3' controlId='formBasicCategory'>
								<Form.Label style={{marginLeft: "10%"}}>카테고리</Form.Label>

								{/* 드롭박스 */}
								<SelectBox id="select_category" name="gameCategoriesUid" options={OPTIONS} value={gameCategoriesUid} onChange={onChangeGameCategoriesUid}></SelectBox>
								{/* <Form.Control style={{width: "60%", textalign:"left", marginLeft:"10%"}} name="gameCategoriesUid" type="text" defaultValue="카테고리" onChange={onChangeGameCategoriesUid} /> */}
							</FormGroup>
							<FormGroup style={{width:"80%", display:"flex", margin:"0 auto"}} >
								<Button style={{marginBottom: "1em", width: "50%", backgroundColor:"#8C4D25", border:"0"}} type="submit" onClick={onSubmit} variant="primary">방 만들기</Button>
								<Button style={{marginBottom: "1em", width: "50%", backgroundColor:"grey", marginLeft:"1em"}} variant="secondary" onClick={onCloseModal}>취소</Button>
							</FormGroup>
						</Modal>
					)}
				</div>
			</footer>
			</div>
		</div>
	);
}
export default Rank;