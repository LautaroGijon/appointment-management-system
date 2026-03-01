# Appointment Management System

A backend Java application that simulates an appointment management system for service-based businesses.

## Features

- Client and Professional registration
- Appointment scheduling
- Appointment confirmation and cancellation
- Business rule validation
- Custom Runtime Exceptions handling

## Business Rules Implemented

- Appointments cannot be created in the past
- Professionals cannot be double-booked
- Explicit validation using custom exceptions:
  - ClientNotFoundException
  - ProfessionalNotFoundException
  - AppointmentNotFoundException
  - InvalidAppointmentDateException
  - ProfessionalUnavailableException

## Technologies Used

- Java 8+
- Object-Oriented Programming (OOP)
- Clean architecture principles
- Git & GitHub version control

## Project Purpose

This project was developed to strengthen backend development skills and apply object-oriented design and exception handling in a real-world scenario.
