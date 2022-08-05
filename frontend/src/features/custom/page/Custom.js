import React from "react";
import { Link } from 'react-router-dom';
import NavBar from "../../../common/navbar/NavBar";
import './Custom.css';

function Custom() {

	return (
		<div className="rank-base">
			<NavBar className="navbar" />
			<h1>자유경연!</h1>
		</div>
	);
}

export default Custom;