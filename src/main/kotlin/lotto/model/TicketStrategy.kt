package lotto.model

interface TicketStrategy {
    fun getLottoTicketNumbers(): List<Int>
}
