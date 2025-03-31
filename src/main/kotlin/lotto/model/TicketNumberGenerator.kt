package lotto.model

interface TicketNumberGenerator {
    fun generateNumbers(): List<Int>
}