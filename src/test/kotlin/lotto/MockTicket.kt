package lotto

import lotto.model.TicketStrategy

class MockTicket : TicketStrategy {
    private var lottoNumbers = listOf(1, 2, 3, 4, 5, 6)

    fun setTicketNumber(numbers: List<Int>) {
        lottoNumbers = numbers
    }

    override fun getLottoTicketNumbers(): List<Int> {
        return lottoNumbers.sorted()
    }
}
