# FleetGo — Cab Booking System (Backend)

## Tech
Spring Boot, Spring Data JPA, Hibernate, MySQL, Spring Security (Basic), Maven

## Run locally
1. Create MySQL DB `Cab_Booking`
2. Update `src/main/resources/application.properties`:
   - spring.datasource.url=jdbc:mysql://localhost:3306/Cab_Booking
   - spring.datasource.username=...
   - spring.datasource.password=...
3. Run in IntelliJ (Run -> CabBookingSystemApplication) or:
   - On Windows: `.\mvnw spring-boot:run`
   - On Linux/macOS: `./mvnw spring-boot:run`

## Seed data
Use the provided Postman collection or curl to create one passenger, one driver, and one cab:
- POST /passengers
- POST /drivers
- POST /cabs

## Test (quick)
1. Create entities (see above)
2. POST /bookings to book a cab
3. Run `concurrent-test.sh` to simulate concurrent requests (to verify optimistic locking)

## Concurrency protection
- `@Version` column on `Cab` enables optimistic locking.
- Service retries up to 3 times on optimistic conflict; returns 409 if it cannot assign.

## Useful endpoints
- `POST /passengers` — create passenger
- `POST /drivers` — create driver
- `POST /cabs` — create cab
- `POST /bookings` — book a cab
- `DELETE /bookings/{id}` — cancel booking

## Next steps
- Add DTO validation (`@Valid`)
- Add Swagger/OpenAPI for documentation
- Add integration tests (Spring Boot Test)
