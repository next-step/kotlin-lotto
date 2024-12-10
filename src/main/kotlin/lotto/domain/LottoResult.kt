package lotto.domain

import kotlin.math.roundToInt

class LottoResult {
    var first: Int = 0
    var second: Int = 0
    var third: Int = 0
    var fourth: Int = 0
    private var totalCount: Int = 0

    /*
        3 / 4 / 5 / 6
        수익률 -> 총상금 / (티켓 수 * 1000) -> 소수 2째 자리 까지 노출
     */
    private val totalPrize by lazy {
        (first * FIRST_PRIZE) + (second * SECOND_PRIZE) + (third * THIRD_PRIZE) + (fourth * FOURTH_PRIZE)
    }
    val returnRate by lazy {
        (totalPrize * 100.0 / (totalCount * TICKET_PRICE)).roundToInt() / 100.0
    }

    val rateString by lazy {
        if (returnRate > 1) "이익" else "손해"
    }

    constructor(lottos: List<LottoTicket>, win: LottoTicket, used: Int = 0) {
        lottos.forEach {
            when (win.correctNumberCount(it)) {
                6 -> first++
                5 -> second++
                4 -> third++
                3 -> fourth++
            }
        }
        this.totalCount = used
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val FIRST_PRIZE = 2000000 * TICKET_PRICE
        const val SECOND_PRIZE = 1500 * TICKET_PRICE
        const val THIRD_PRIZE = 50 * TICKET_PRICE
        const val FOURTH_PRIZE = 5 * TICKET_PRICE
    }
}
