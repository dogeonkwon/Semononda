import React from 'react';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import './App.css';
import Game from '../features/game/Game'
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
        <Routes>
          <Route exact path="/" element={<Main/>}/>
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/signin" element={<SignUp/>}/>
          <Route exact path="/rank" element={<Rank/>}/>
          <Route exact path="/custom" element={<Custom/>}/>
          <Route exact path="/roomitem" element={<RoomItem/>}/>
          <Route exact path="/me" element={<MyPage/>}/>
      	  <Route path="/game/:id" element={<Game />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
