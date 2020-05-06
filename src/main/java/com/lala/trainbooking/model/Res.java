package com.lala.trainbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (c) 2018. scicom.com.my - All Rights Reserved
 * Created by kalana.w on 5/6/2020.
 */
@Data
@AllArgsConstructor
public class Res<T> implements Serializable
{
	private T data;
	private String message;
}
