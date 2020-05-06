package com.lala.trainbooking.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Copyright (c) 2018. scicom.com.my - All Rights Reserved
 * Created by kalana.w on 5/6/2020.
 */
@Data
public class Booking
{
	private int bookingId;
	private String bookingCode;
	private String userId;
	private String userName;
	private String ticketPrice;
	private LocalDateTime ticketValidTo;
	private String trainId;
	private String from;
	private String to;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	private String distance;
	private String timeToReach;
}
