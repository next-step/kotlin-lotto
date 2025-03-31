# kotlin-lotto

## Process

1. Input purchase
2. Calculate purchased amount of tickets
3. Generate purchased tickets
4. Input winning numbers
5. Calculate matches
6. Calculate return rate
7. Display result

## MVC

### Model
1. Ticket
2. Purchased Tickets
3. Lotto Result
### View
1. Input View
2. Result View
### Controller
1. Lotto Controller

## TDD 

### 1. Ticket
- [x] 1.1. ticket should contain 6 numbers
- [x] 1.2. should fail if numbers less or more then 6

### 2. Purchased Ticket
- [X] 2.1. should calculate correct number of tickets based on purchased amount  
- [x] 2.2. should generate tickets with correct numbers using generator
- [x] 2.3. should return empty list if purchased amount less that ticket price
- [ ] 2.4. should fail if purchased amount is negative
