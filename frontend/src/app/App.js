import React from 'react';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import './App.css';
import Main from '../features/home/page/Home';
import Login from '../features/user/page/Login';
import SignUp from '../features/user/page/SignUp';
import Custom from '../features/custom/page/Custom';
import MyPage from '../features/mypage/page/MyPage';
import Rank from '../features/rank/page/Rank';
import NavBar from "../common/navbar/NavBar";

function App() {
  return (
    <Router>
      <NavBar />
      <div>
        <Routes>
          <Route exact path="/" element={<Main/>}/>
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/signin" element={<SignUp/>}/>
          <Route exact path="/rank" element={<Rank/>}/>
          <Route exact path="/custom" element={<Custom/>}/>
          <Route exact path="/me" element={<MyPage/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
