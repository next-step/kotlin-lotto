package lotto.model

class RandomTicketNumberGenerator: TicketNumberGenerator {
    override fun generateNumbers(): List<Int> {
        return (1..45).shuffled().take(6).toList()
    }
}