import React from "react";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import './Room.css';
import red_room from '../../../assets/images/red_room.png'

const Catgory = [
    "더미",
    "더미데이터",
    "일상생활",
    "음식",
    "개발자",
    "MBTI",
    "연애",
    "극과 극",
    "교육",
];


const Logo = [
    "더미",
    "더미데이터",
    "daily_life",
    "food",
    "computer",
    "mbti",
    "love",
   "opposite",
    "education",
];


function Room(props) {
    const { title, gameCategoriesUid, adminNickname} = props;

    return (
        // <Card>
            <div className="gameroom">
                <div className="image">
                    <Card.Img style={{ width: '10rem' }} variant="top" src={`${Logo[gameCategoriesUid]}.png`} />
                </div>
                <div className="body">
                    <Card.Body>
                        <Card.Title>{title}</Card.Title>
                        <Card.Title>
                            방 카테고리 : {Catgory[gameCategoriesUid]}
                        </Card.Title>
                        <Card.Title>
                            주최자 : {adminNickname}
                        </Card.Title>
                        <button className="enter">입장하기</button>
                    </Card.Body>
                </div>
            </div>
        // </Card>
    );
}

export default Room;