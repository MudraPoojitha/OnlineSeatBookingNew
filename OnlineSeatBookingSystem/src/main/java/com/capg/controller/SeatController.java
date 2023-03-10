package com.capg.controller;

import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Seat;
import com.capg.exception.SeatNotFoundException;
import com.capg.service.SeatService;

@RestController
@RequestMapping("/onlineseat-seat")
public class SeatController {

	@Autowired
	SeatService seatService;

	@PostMapping("/addSeat")
	public String addSeats(@RequestBody Seat seat)
	{
		return seatService.addSeats(seat);
	}
	
	
	@GetMapping("/listAllSeat")
	public List<Seat> listAllSeats(){
		return seatService.listAllSeats();
	}
	
	@GetMapping("/getSeatById/{seatNumber}")
	public Seat getSeatsById(@PathVariable String seatNumber) throws SeatNotFoundException
	{
		
		return seatService.getSeatsBySeatNumber(seatNumber);
	}

	@GetMapping("/findBySeatFloor/{seatFloor}")
	public Seat findBySeatFloor(@PathVariable int seatFloor)
	{
		return seatService.findBySeatFloor(seatFloor);
	}
	
	
	@GetMapping("/findBySeatLocation/{seatLocation}") 
	public List<Seat> findBySeatLocation(@PathVariable  String seatLocation) 
	{
		return seatService.findBySeatLocation(seatLocation);
	}

	@PutMapping("/updateSeat/{emailId}")
	public Seat updateSeats(@RequestBody Seat seat)throws SeatNotFoundException
	{
		return seatService.updateSeat(seat);
	}
	
	@DeleteMapping("/deleteSeats/{seatNumber}")
	public void deleteSeats(@PathVariable String seatNumber)
	{
		seatService.deleteSeats(seatNumber);
	}
	
	@PutMapping("/bookSeat/{seatId}")
	public Seat bookSeat(@PathVariable int seatId) throws SeatNotFoundException{
		return seatService.bookSeat(seatId);
	}


}
