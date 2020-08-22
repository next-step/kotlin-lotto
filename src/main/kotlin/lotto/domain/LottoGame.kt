package lotto.domain

object LottoGame {

    private const val LOTTO_NUMBER_COUNT_PER_TICKET = 6
    private const val LOTTO_TICKET_PRICE = 1000
    private val LOTTO_NUMBER = (LottoNumber.LOTTO_MIN_NUMBER..LottoNumber.LOTTO_MAX_NUMBER).map { LottoNumber(it) }

    fun createLottoTicket(price: Int, manualLottoCount: List<LottoNumber>): LottoTickets{
        if (price < LOTTO_TICKET_PRICE) throw IllegalArgumentException("최소 1000원 이상의 금액을 입력해야합니다.")

        val manualLottos = (1..manualLottoCount.size).map { makeNumbers(manualLottoCount) }

        val totalCountTicket = getTicketCount(price)
        val automaticLottoCount = totalCountTicket - manualLottos.size

        val autoLottos = (1..automaticLottoCount).map { makeNumbers() }

        return LottoTickets.from(manualLottos + autoLottos)
    }

    // 자동
    fun makeNumbers(): LottoTicket {
        val autoLottoNumber: List<LottoNumber> = LOTTO_NUMBER.shuffled().take(LOTTO_NUMBER_COUNT_PER_TICKET)
        return LottoTicket.from(autoLottoNumber)
    }

    // 수동
   fun makeNumbers(lottoTicket: List<LottoNumber>): LottoTicket {
        return LottoTicket.from(lottoTicket)
    }

    fun getTicketCount(money: Int) = money / LOTTO_TICKET_PRICE

    fun calculate(inputMoney: Int, lottoResults: List<Rank>): Double {
        val totalMoney = totalPrizeMoney(lottoResults)
        val usedMoney = (inputMoney/ LOTTO_TICKET_PRICE) * LOTTO_TICKET_PRICE
        return (totalMoney.toDouble() / usedMoney)
    }

    private fun totalPrizeMoney(lottoResults: List<Rank>): Int {
        return lottoResults.map { it.prizeMoney }.sum()
    }
}