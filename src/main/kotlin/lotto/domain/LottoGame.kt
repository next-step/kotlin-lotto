package lotto.domain

object LottoGame {

    private const val LOTTO_NUMBER_COUNT_PER_TICKET = 6
    private const val LOTTO_TICKET_PRICE = 1000
    private val LOTTO_NUMBER = (LottoNumber.LOTTO_MIN_NUMBER..LottoNumber.LOTTO_MAX_NUMBER).map { LottoNumber(it) }

    fun makeTickets(price: Int): List<LottoTicket> {
        if (price < LOTTO_TICKET_PRICE) throw IllegalArgumentException("최소 1000원 이상의 금액을 입력해야합니다.")
        val countTicket = getTicketCount(price)
        return IntRange(1, countTicket).map { makeAutoNumbers() }
    }

    private fun makeAutoNumbers(): LottoTicket {
        return LOTTO_NUMBER.shuffled().take(LOTTO_NUMBER_COUNT_PER_TICKET).let { LottoTicket(it) }
    }

    private fun getTicketCount(money: Int) = money / LOTTO_TICKET_PRICE

    fun calculate(usedMoney: Int, lottoResults: List<Rank>): Double {
        val totalMoney = totalPrizeMoney(lottoResults)
        return (totalMoney / usedMoney) * 100.0
    }

    private fun totalPrizeMoney(lottoResults: List<Rank>): Int {
        return lottoResults.map { it.prizeMoney }.sum()
    }
}
