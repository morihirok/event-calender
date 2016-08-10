package com.example.web;

import lombok.Data;

/**
 * ログインするユーザを表すフォーム.
 * 
 * @author kazushige.morihiro
 *
 */
@Data
public class UserForm {
	private String name;
	private String password;
}
