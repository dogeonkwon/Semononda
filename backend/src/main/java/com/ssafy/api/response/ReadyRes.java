package com.ssafy.api.response;

import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Player;
import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ReadyResponse")
public class ReadyRes{
	@ApiModelProperty(name="User ID")
	String userId;
	@ApiModelProperty(name="Ready State")
	boolean readyState;

	public static ReadyRes of(String userId, boolean readyState) {
		ReadyRes res = new ReadyRes();
		res.setUserId(userId);
		res.setReadyState(readyState);
		return res;
	}
}
