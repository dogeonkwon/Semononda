import React from "react";
import { Link } from "react-router-dom";

const RoomItem = (room) => {
    const handleEnterRoom = () => {
      WebSocket.emit("room_enter", room.name);
    };
  
    return (
      <li key={room.name} className="room-list__item">
        <p className="room-list__name">{room.name}</p>
        <button className="room-list__enter" onClick={handleEnterRoom}>
          입장하기
        </button>
      </li>
    );
  };
  
  const RoomList = () => {
    const [roomList, setRoomList] = React.useState([]);
  
    WebSocket.on("room_change", (list) => {
      setRoomList(list);
    });
  
    return (
      <div className="room-list">
        <h3>방 목록</h3>
        <ul className="room-list__container">{roomList.map(RoomItem)}</ul>
      </div>
    );
  };

export default RoomItem;