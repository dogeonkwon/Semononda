import React from 'react';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import './App.css';
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
        </Routes>
      </div>
    </Router>
  );
}

export default App;
