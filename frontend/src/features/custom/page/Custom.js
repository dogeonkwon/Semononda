import React, {useState} from "react";
import NavBar from "../../../common/navbar/NavBar";
import './Custom.css';

function Custom() {

	const [isCustom, setIsCustom] = useState(true);

	return (
		<div id="Container" className="rank-base">
			<NavBar className="navbar" isCustom={isCustom}/>
			<h1>자유경연</h1>
		</div>
	);
}

export default Custom;