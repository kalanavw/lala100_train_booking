package com.lala.trainbooking.services;

import com.lala.trainbooking.model.Booking;
import com.lala.trainbooking.model.BookingRequest;
import com.lala.trainbooking.model.Res;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (c) 2018. scicom.com.my - All Rights Reserved
 * Created by kalana.w on 5/6/2020.
 */
@Service
public class BookingService
{
	private Map<Integer, Booking> results = new ConcurrentHashMap<>();

	public Res<Map<Integer, Booking>> findAllBookings()
	{
		if ( this.results.isEmpty() )
		{
			return new Res<>( new ConcurrentHashMap<>(), "Booking list is empty" );
		}
		return new Res<>( this.results, "Found booking data" );
	}

	public Res<Booking> createNewBooking( BookingRequest bookingRequest )
	{
		Booking booking = new Booking();
		int bookingId = this.results.size() + 1;
		booking.setBookingId( bookingId );
		booking.setBookingCode( "B".concat( String.valueOf( bookingId ) ) );
		booking.setUserId( "USER-".concat( String.valueOf( bookingId ) ) );
		booking.setUserName( bookingRequest.getUserName() );
		booking.setTicketPrice("$".concat( String.valueOf( getRandomInteger( 100, 10 ) ) ));
		booking.setTicketValidTo( LocalDateTime.now().plusDays( 1 ) );
		booking.setTrainId("UK-T-".concat( String.valueOf( getRandomInteger( 100, 10 ) ) ) );
		booking.setFrom(bookingRequest.getFrom());
		booking.setTo(bookingRequest.getTo());
		booking.setArrivalTime(LocalDateTime.now().plusMinutes( 10 ));
		booking.setDepartureTime(LocalDateTime.now().plusMinutes( 12 ));
		booking.setDistance(String.valueOf( getRandomInteger( 1000, 50 ) ).concat( " km" )  );
		booking.setTimeToReach((getRandomInteger( 15, 2 ))+" Hours");

		this.results.put( bookingId, booking );
		return new Res<>( booking, "Train booking success" );
	}

	public static int getRandomInteger( int maximum, int minimum )
	{
		return ( ( int ) ( Math.random() * ( maximum - minimum ) ) ) + minimum;
	}

}
