import React from 'react';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import './App.css';
import Main from '../features/home/page/Home';
import Login from '../features/user/page/Login';
import SignUp from '../features/user/page/SignUp';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route exact path="/" element={<Main/>}/>
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/signin" element={<SignUp/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
