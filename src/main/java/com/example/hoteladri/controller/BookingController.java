package com.example.hoteladri.controller;

import com.example.hoteladri.dto.BookingDTO;
import com.example.hoteladri.dto.PaymentDTO;
import com.example.hoteladri.model.Booking;
import com.example.hoteladri.model.Client;
import com.example.hoteladri.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class BookingController {
        
        @Autowired
        private BookingService reservaService;
        
        @GetMapping
        public List<BookingDTO> obtainAllBookings() {
            return reservaService.obtainAllBookings();
        }

        @GetMapping("/{id}")
        public BookingDTO obtainBookingById(@PathVariable Long id) {
            return reservaService.obtainBookingById(id);
        }

        @GetMapping("/cliente/{cliente}")
        public List<BookingDTO> obtainBookingByClient(@PathVariable Client cliente) {
            return reservaService.obtainBookingByClient(cliente);
        }

        @PostMapping
        @RequestMapping("/habitacion/{habitacion}/crear")
        public BookingDTO keepBooking(@PathVariable int habitacion, @RequestBody Booking reserva) {
            return reservaService.keepBooking(reserva, habitacion);
        }

        @PostMapping
        @RequestMapping("/habitacion/{habitacion}/confirmar")
        public PaymentDTO confirmBooking(@PathVariable int habitacion, @RequestBody Booking reserva) {
            return reservaService.confirmBooking(reserva, habitacion);
        }

        @DeleteMapping("/habitacion/{habitacion}/cancelar")
        public void cancelBooking(@PathVariable int habitacion, @RequestBody Booking reserva) {
            reservaService.cancelBooking(reserva, habitacion);
        }
        
}
