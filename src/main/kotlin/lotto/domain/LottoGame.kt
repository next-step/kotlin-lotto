package lotto.domain

class LottoGame {

    fun makeTickets(price: Int): List<LottoTicket> {
        val countTicket = getTicketCount(price)
        return IntRange(1, countTicket).map { makeAutoNumbers() }
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT_PER_TICKET = 6
        private const val LOTTO_TICKET_PRICE = 1000
        private val lottoNumber = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).map { LottoNumber(it) }
    }

    private fun makeAutoNumbers(): LottoTicket {
        return lottoNumber.shuffled().take(LOTTO_NUMBER_COUNT_PER_TICKET).let { LottoTicket(it) }
    }

    private fun getTicketCount(money: Int) = money / LOTTO_TICKET_PRICE
}
