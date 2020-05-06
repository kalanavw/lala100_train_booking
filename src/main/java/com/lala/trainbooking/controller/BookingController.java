package com.lala.trainbooking.controller;

import com.lala.trainbooking.model.Booking;
import com.lala.trainbooking.model.BookingRequest;
import com.lala.trainbooking.model.Res;
import com.lala.trainbooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Copyright (c) 2018. scicom.com.my - All Rights Reserved
 * Created by kalana.w on 5/6/2020.
 */
@RestController
@RequestMapping("booking")
public class BookingController
{
	@Autowired
	private BookingService bookingService;

	@GetMapping
	public ResponseEntity<Res<Map<Integer, Booking>>> getBookingList()
	{
		return ResponseEntity.ok( this.bookingService.findAllBookings() );
	}

	@PostMapping
	public ResponseEntity<Res<Booking>> createNewBooking( @RequestBody BookingRequest bookingRequest )
	{
		if ( bookingRequest.getUserName() == null || bookingRequest.getUserName().trim().isEmpty() )
		{
			return ResponseEntity.badRequest().body( new Res<>( null, "Invalid user name" ) );
		}
		if ( bookingRequest.getTo() == null || bookingRequest.getTo().trim().isEmpty() )
		{
			return ResponseEntity.badRequest().body(new Res<>( null, "Invalid designation" ));
		}
		if ( bookingRequest.getFrom() == null || bookingRequest.getFrom().trim().isEmpty() )
		{
			return ResponseEntity.badRequest().body(new Res<>( null, "Invalid from" ));
		}
		return ResponseEntity.ok( this.bookingService.createNewBooking( bookingRequest ) );
	}
}
