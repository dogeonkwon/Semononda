import React from 'react';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import './App.css';
<<<<<<< HEAD
import Signin  from '../features/user/page/SignUp';
import Login from '../features/user/page/Login';
import Main from '../features/home/page/Home';


function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route exact path="/signin" element={<Signin/>} />
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/" element={<Main/>}/>
=======
import Main from '../features/home/page/Home';
import Login from '../features/user/page/Login';
import SignUp from '../features/user/page/SignUp';
import Custom from '../features/custom/page/Custom';
import Rank from '../features/rank/page/Rank';
import RoomItem from '../features/rank/page/RoomItem';
import MyPage from '../features/mypage/page/MyPage';
import NotFound from '../features/notfound/NotFound';
// import NavBar from "../common/navbar/NavBar";

function App() {
  return (
    <Router>
      <div>
        {/* <NavBar /> */}
        <Routes>
          <Route exact path="/" element={<Main/>}/>
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/signin" element={<SignUp/>}/>
          <Route exact path="/rank" element={<Rank/>}/>
          <Route exact path="/custom" element={<Custom/>}/>
          <Route exact path="/roomitem" element={<RoomItem/>}/>
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git
        </Routes>
      </div>
    </Router>
  );
}

export default App;
