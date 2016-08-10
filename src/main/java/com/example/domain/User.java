package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ログインするユーザを表すクラス.
 * 
 * @author kazushige.morihiro
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String name;
	private String password;
}
