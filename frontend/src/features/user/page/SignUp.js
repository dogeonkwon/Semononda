import React, {useState} from 'react'
import {Button, Form, FormGroup} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';

function Signin() {

    //서버로 전달할 user객체
   const [user, setUser] = useState({
    id : "",
    name: "",
    nickname : "",
    password : "",
    phonenumber : ""
   })

   //user객체 바인딩
   const { id, name, nickname, password, phonenumber } = user;

    //비밀번호 확인을 위한 변수
   const [confirmPassword, setConfirmPassword] = useState("");

    
     //오류메시지 상태저장
    const [idMessage, setIdMessage] = useState('')
    const [nameMessage, setNameMessage] = useState('')
    const [nicknameMessage, setNicknameMessage] = useState('')
    const [passwordMessage, setPasswordMessage] = useState('')
    const [confirmPasswordMessage, setConfirmPasswordMessage] = useState('') 
    const [phonenumberMessage, setPhonenumberMessage] = useState('')

    // 유효성 검사 상태 저장
    const [isId, setIsId] = useState(false);
    const [isName, setIsName] = useState(false);
    const [isNickname, setIsNickname] = useState(false)
    const [isPassword, setIsPassword] = useState(false)
    const [isConfirmPassword, setIsConfirmPassword] = useState(false)
    const [isPhonenumber, setIsPhonenumber] = useState(false)

    //유효성 검사
    //아이디
    const onChangeId = (e) => {
        //숫자, 영어만 사용
        const idRegex = /([0-9a-zA-Z])/
        const { name, value } = e.target;
        setUser({
            ...user, 
            [name]: value,
          });
        //글자 수 5~16 제한
        if (!idRegex.test(user.id) || e.target.value.length < 5 || e.target.value.length > 16) {
          setIdMessage('5~16글자로 입력해주세요.')
          setIsId(false)
        } else {
          setIdMessage('확인되었습니다.')
          setIsId(true)
        }
      }
    
    //이름
    const onChangeName = (e) => {
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value
        });
        //글자 수 30자 이내로 제한
        if(e.target.value.length >30) {
            setNameMessage('30자 이내로 입력 가능합니다.')
            setIsName(false)
        } else {
            setNameMessage('확인되었습니다.')
            setIsName(true)
        }
    }

    //닉네임
    const onChangeNickname = (e) => {
        //한글, 영어, 숫자 사용가능
        const nicknameRegex = /([ㄱ-ㅎ|가-힣|0-9|a-z|A-Z])/
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value
        });
        //30자 이내로 입력가능
        if(!nicknameRegex.test(user.nickname) || e.target.value.length >30) {
            setNicknameMessage('30자 이내로 입력 가능합니다.')
            setIsNickname(false)
        }else {
            setNicknameMessage('확인되었습니다.')
            setIsName(true)
        }
    }

    //비밀번호
    const onChangePassword = (e) => {
        console.log(e.target.value)
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value,
        });
        //9~16글자 작성가능
        if(e.target.value.length <9 || e.target.value.length >16){
            setPasswordMessage('9~16글자로 입력해주세요')
            setIsPassword(false)
        } else {
            setPasswordMessage('확인되었습니다.')
            setIsPassword(true)
        }
    }

    //비밀번호 확인
    const onChangeConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);
        //비밀번호와 비밀번호 확인이 다른경우
        if(user.password !== e.target.value){
            setConfirmPasswordMessage('비밀번호가 일치하지 않습니다.')
            setIsConfirmPassword(false)
        } else {
            setConfirmPasswordMessage('확인되었습니다.')
            setIsConfirmPassword(true)
        }
    }

    //전화번호
    const onChangePhoneNumber = (e) => {
        //숫자만 입력
        const phonenumberRegex = /[0-9]/;
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value,
        });
        if(!phonenumberRegex.test(user.phonenumber) || e.target.value.length !== 11){
            console.log(e)
            setPhonenumberMessage('전화번호 11자리를 숫자만 입력해 주세요')
            setIsPhonenumber(false)
        } else {
            setPhonenumberMessage('확인되었습니다.')
            setIsPhonenumber(true)
        }
    }

    //닉네임 중복값 인증
    const onCheckNickname = async (event) => {
        axios
          .get(`/user/nickname-info/${nickname}`)
          .then(function (response) {
            console.log(response);
          })
          //실패 시 catch 실행
          .catch(function (error) {
            console.log(error);
          })
          //성공이던 실패던 항상 실행
          .then(function () {
            // always executed
          });
        
    };

    //가입버튼 눌렀을 때 호출되는 함수
    const onSubmit = (event) => {
    
    //콘솔 확인
    console.log("user",user)
    
    const jsonUser = JSON.stringify(user)
    console.log("userJson",jsonUser);
    sessionStorage.setItem('jsonUser',jsonUser);
    //입력값 남겨두는 함수
    event.preventDefault()

    if((user.id === '' || user.name === '' || user.nickname === '' || user.password === '' || user.phonenumber === '')){
        alert('모든 정보를 입력해주세요');
        console.log(user);
    }else{
        alert('회원가입 완료');
        console.log(user);
    }
    
  }

  //회원가입 폼
  return (
      <Form style={{margin:"1em"}}>
        <FormGroup className='mb-3' controlId='formBasicId'>
            <Form.Label>아이디</Form.Label>
            <Form.Control name='id' type='id' placeholder='아이디' value={id} onChange={onChangeId}/>
            {id.length > 0 && <span className={`message ${isId ? 'success' : 'error'}`}>{idMessage}</span>}
        </FormGroup>
        <FormGroup className='mb-3' controlId='formBasicName'>
            <Form.Label>이름</Form.Label>
            <Form.Control name="name" type="text" placeholder="이름" value={name} onChange={onChangeName} />
            {name.length > 0 && <span className={`message ${isName ? 'success' : 'error'}`}>{nameMessage}</span>}
        </FormGroup>
        <FormGroup className='mb-3' controlId='formBasicNickname'>
            <Form.Label>별호</Form.Label>
            <Form.Control name="nickname" type="text" placeholder="별호" value={nickname} onChange={onChangeNickname} />
            {nickname.length > 0 && <span className={`message ${isNickname ? 'success' : 'error'}`}>{nicknameMessage}</span>}
            <Button onClick={onCheckNickname} variant='primary'>중복검사</Button>
        </FormGroup>
        <FormGroup>
        <FormGroup className='mb-3' controlId='formBasicPassword'>
            <Form.Label>비밀번호</Form.Label>
            <Form.Control name="password" type="password" placeholder="비밀번호" value={password} onChange={onChangePassword} />
            {password.length > 0 && <span className={`message ${isPassword ? 'success' : 'error'}`}>{passwordMessage}</span>}
        </FormGroup>
        <FormGroup className='mb-3' controlId='formBasicConfirmPassword'>
            <Form.Label>비밀번호 확인</Form.Label>
            <Form.Control name="confirmPassword" type="password" placeholder="비밀번호 확인" value={confirmPassword} onChange={onChangeConfirmPassword} />
            {confirmPassword.length > 0 && <span className={`message ${isConfirmPassword ? 'success' : 'error'}`}>{confirmPasswordMessage}</span>}
        </FormGroup>
        <FormGroup></FormGroup>
        <FormGroup  className='mb-3' controlId='formBasicPhoneNumber'>
            <Form.Label>휴대폰 번호</Form.Label>
         <Form.Control name="phonenumber" type="text" placeholder="휴대폰 번호" value={phonenumber} onChange={onChangePhoneNumber}/>
         {phonenumber.length > 0 && <span className={`message ${isPhonenumber ? 'success' : 'error'}`}>{phonenumberMessage}</span>}
        </FormGroup>
        </FormGroup>
        <FormGroup style={{textAlign:"center"}} >
          <Button type="submit" onClick={onSubmit} variant="primary">계정 생성하기</Button>
        </FormGroup>
      </Form>
  );
}
export default Signin;