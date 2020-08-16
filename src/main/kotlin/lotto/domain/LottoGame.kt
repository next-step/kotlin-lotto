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
        return LOTTO_NUMBER.shuffled().take(LOTTO_NUMBER_COUNT_PER_TICKET).sortedBy { it.number }.let { LottoTicket(it) }
    }

    private fun getTicketCount(money: Int) = money / LOTTO_TICKET_PRICE

    fun calculate(inputMoney: Int, lottoResults: List<Rank>): Double {
        val totalMoney = totalPrizeMoney(lottoResults)
        val usedMoney = (inputMoney/ LOTTO_TICKET_PRICE) * LOTTO_TICKET_PRICE
        return (totalMoney.toDouble() / usedMoney)
    }

    private fun totalPrizeMoney(lottoResults: List<Rank>): Int {
        return lottoResults.map { it.prizeMoney }.sum()
    }
}
