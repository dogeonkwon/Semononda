 package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel("UserLoginIdRequest")
public class UserIdReq {
	@ApiModelProperty(name="유저 ID", example="ssafy")
	String id;
}