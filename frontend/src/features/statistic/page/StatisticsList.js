import React, { useState, useEffect } from "react";
import Room from './Room';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import './Room.css';


// api를 가져와서 차례대로 보여줌
function StatisticsList({ data }) {
  return (
    <Row xs={1} md={2}>
            {data.map((room) => (
              <Col>
              <Room key={room.uid} {...room} />
              </Col>
            ))}
    </Row>
    );
  }


export default StatisticsList;