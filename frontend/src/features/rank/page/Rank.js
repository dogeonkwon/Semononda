import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';
import styled from "styled-components";
import logo from "../../../assets/images/logo.png"
import NavBar from "../../../common/navbar/NavBar";
import './Rank.css';
import Pagination from "./Pagination";
import RoomItem from "./RoomItem";


const Layout = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 auto;
  background-size: cover;
`;


function Rank() {

	const [isRank, setIsRank] = useState(true);
	const [posts, setPosts] = useState([]);
	const [limit, setLimit] = useState(6);
	const [page, setPage] = useState(1);
	const offset = (page - 1) * limit;

	useEffect(() => {
	  fetch("https://jsonplaceholder.typicode.com/posts")
		.then((res) => res.json())
		.then((data) => setPosts(data));
	}, []);

	return (
		<div className="rank-base">
			<NavBar isRank={isRank}/>
			{/* 제목 */}
			<header>
				<button>공식경연 방 생성</button>
			</header>
				
			{/* 방 생성 화면(메인) */}
			<main>
												{/* {posts.slice(offset, offset + limit).map(({ id, title, body }) => (
													<article key={id}>
														<h3>
															{id}. {title}
														</h3>
														<p>{body}</p>
													</article>
												))} */}
				<div className="room_container">
					<div className="room_items">
						<RoomItem 
						src = {logo}
						text = "랭크모드"
						label = 'Adventure'
						path='/custom'
						pesonnel = "1/7"
						title = "너만 오면 고"
						/>
													{/* <div className="red_room">
														<img className="logo" src={logo} />
														<div className="room_info">
															<ul>
															<button>너만 오면 고</button>
															<button>연애</button>
															</ul>
															<ul>
															<button>1/7</button>
															<button>주최자 : 총총이아빠</button>
															</ul>
														</div>
													</div>
													<div className="red_room">
														<p>랭크방</p>
													</div>
													</div>
													<div className="room_items">
													<div className="red_room">
														<p>랭크방</p>
													</div>
													<div className="red_room">
														<p>랭크방</p>
													</div>
													</div>
													<div className="room_items">
													<div className="red_room">
														<p>랭크방</p>
													</div>
													<div className="red_room">
														<p>랭크방</p>
													</div */}
					</div>
				</div>
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
				</div>
			</footer>
		</div>
	);
}
export default Rank;