package lotto.domain

object LottoConstants {
    private const val TICKET_PRICE = 1000
    private const val PRIZE_MATCH_3 = 5000
    private const val PRIZE_MATCH_4 = 50000
    private const val PRIZE_MATCH_5 = 1500000
    private const val PRIZE_MATCH_6 = 2000000000

    fun getTicketPrice() = TICKET_PRICE
    fun getPrizeMatch3() = PRIZE_MATCH_3
    fun getPrizeMatch4() = PRIZE_MATCH_4
    fun getPrizeMatch5() = PRIZE_MATCH_5
    fun getPrizeMatch6() = PRIZE_MATCH_6
}
