import React, {useState} from 'react'
import {Button, Form, FormGroup} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import { useDispatch } from 'react-redux';
import {useNavigate}from 'react-router-dom'
import { toast } from 'react-toastify';
import {login} from '../UserSlice';

function Login() {
  const dispatch = useDispatch();
  const history = useNavigate();

  //id
  const [userId, setId] = useState("");
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
  const onSubmit = (e) => {
    console.log(e)
    e.preventDefault();
    const data = {
      userId,
      password,
    };
    dispatch(login(data))
    
    .then(() => {
        history("/login", {replace: true})
      })
      .catch((err) => {
        if (err.status === 400) {
          toast.error('😥 입력하신 정보를 다시 확인해주세요');
        } else if (err.status === 409) {
          toast.error('😥 이미 로그인된 사용자입니다');
        } else if (err.status === 401) {
          toast.error('😥 아이디와 비밀번호를 다시 확인해주세요');
          history.push('/login');
        } else if (err.status === 500) {
          history.push('/error');
        }
      });
  }

  return (
      <Form style={{margin:"1em"}}>
        <FormGroup className='mb-3'>
            <Form.Control name="userId" type="id" placeholder="아이디" value={userId} onChange={onIdHandler}/>
        </FormGroup>
        <FormGroup className='mb-3'>
            <Form.Control name="password" type="password" placeholder="비밀번호" value={password} onChange={onPasswordHandler}/>
        </FormGroup>
        <FormGroup style={{textAlign:"center"}}>
            <Button type="submit" onClick={onSubmit}>로그인</Button>
        </FormGroup>
      </Form>
    );
  }

export default Login;