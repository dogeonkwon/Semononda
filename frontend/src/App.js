import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import './App.css';
import Signin  from './components/user/Signin.js';
import Login from './components/user/Login.js';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route exact path="/signin" element={<Signin/>} />
          <Route exact path="/login" element={<Login/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
