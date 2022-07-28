import React, {useState} from 'react'
import {Button, Form, FormGroup} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';

function Login() {

  //id
  const [id, setId] = useState("");
  //password
  const [password, setPassword] = useState(""); 
  
  //Idhandler
  const onIdHandler = (event) => {
    setId(event.currentTarget.value);
  }

  //Passwordhandler
  const onPasswordHandler = (event) => {
    setPassword(event.currentTarget.value);
  }

  //로그인 버튼 누르면 실행되는 함수
  const onSubmit = (event) => {
    event.preventDefault();

    axios.post(`localhost:8080/user/login`)
    .then(function (response){

    })
    .catch(function (error){
        
    })

  }

  return (
      <Form style={{margin:"1em"}}>
        <FormGroup className='mb-3'>
            <Form.Control name="id" type="id" placeholder="아이디" value={id} onChange={onIdHandler}/>
        </FormGroup>
        <FormGroup className='mb-3'>
            <Form.Control name="password" type="password" placeholder="비밀번호" value={password} onChange={onPasswordHandler}/>
        </FormGroup>
        <FormGroup style={{textAlign:"center"}}>
            <Button type="submit" onSubmit={onSubmit}>로그인</Button>
        </FormGroup>
      </Form>
    );
  }

export default Login;