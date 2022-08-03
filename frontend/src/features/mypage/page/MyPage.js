import React from "react";
import {useSelector} from "react-redux";

function MyPage(){
  let user_info = useSelector(state => state.user.user);
  console.log("user_info",user_info)

  return (
    <div>
      <h1>마이페이지!!</h1>
    </div>
  );
};

export default MyPage;