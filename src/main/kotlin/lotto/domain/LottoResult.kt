package lotto.domain

import lotto.domain.LottoResult.RateResultString.LOSS
import lotto.domain.LottoResult.RateResultString.WIN
import kotlin.math.roundToInt

class LottoResult(tickets: List<LottoTicket>, win: LottoTicket, used: Int = 0) {
    var first: Int = 0
    var second: Int = 0
    var third: Int = 0
    var fourth: Int = 0
    private var totalCount: Int = used

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

    val rateResultString: String
        get() = if (returnRate > 1) WIN.koreanText else LOSS.koreanText

    init {
        tickets.forEach {
            when (win.correctNumberCount(it)) {
                6 -> first++
                5 -> second++
                4 -> third++
                3 -> fourth++
            }
        }
    }

    private enum class RateResultString(val koreanText: String) {
        WIN("이익"),
        LOSS("손해"),
    }

    companion object {
        const val TICKET_PRICE = 1_000
        const val FIRST_PRIZE = 2_000_000 * TICKET_PRICE
        const val SECOND_PRIZE = 1_500 * TICKET_PRICE
        const val THIRD_PRIZE = 50 * TICKET_PRICE
        const val FOURTH_PRIZE = 5 * TICKET_PRICE
    }
}
