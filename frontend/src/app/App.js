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
import EditMyPage from '../features/mypage/page/MyPageEdit';
import Help from '../features/help/page/Help';
import Statistics from '../features/statistic/page/Statistics';
import UserRank from '../features/userrank/page/UserRank';
import NotFound from '../features/notfound/NotFound';
import NavBar from '../common/navbar/NavBar';

function App() {
  return (
    <>
    <Router>
        <Routes>
          <Route exact path="/" element={<Main/>}/>
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/signin" element={<SignUp/>}/>
          <Route exact path="/rank" element={<Rank/>}/>
          <Route exact path="/custom" element={<Custom/>}/>
          <Route exact path="/roomitem" element={<RoomItem/>}/>
          <Route exact path="/profile" element={<MyPage/>}/>
          <Route exact path="/editprofile" element={<EditMyPage/>}/>
      	  <Route exact path="/game/:id" element={<Game />} />
      	  <Route exact path="/help" element={<Help />} />
      	  <Route exact path="/statistics" element={<Statistics />} />
      	  <Route exact path="/userrank" element={<UserRank />} />
      	  <Route exact path="/*" element={<NotFound />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
