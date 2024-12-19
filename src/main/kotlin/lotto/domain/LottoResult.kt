package lotto.domain

import lotto.domain.LottoResult.RateResult.LOSS
import lotto.domain.LottoResult.RateResult.WIN
import kotlin.math.roundToInt

class LottoResult(tickets: List<LottoTicket>, win: LottoWinner, used: Int = 0) {
    var first: Int = 0
    var second: Int = 0
    var third: Int = 0
    var fourth: Int = 0
    var fifth: Int = 0
    private var totalCount: Int = used

    private val totalPrize by lazy {
        Rank.FIRST.prize(first) + Rank.SECOND.prize(second) + Rank.THIRD.prize(third) + Rank.FOURTH.prize(fourth) + Rank.FIFTH.prize(fifth)
    }
    val returnRate by lazy {
        (totalPrize * 100.0 / (totalCount * TICKET_PRICE)).roundToInt() / 100.0
    }

    val rateResult: RateResult
        get() = if (returnRate > 1) WIN else LOSS

    init {
        tickets.forEach {
            updateRank(win.getRank(it))
        }
    }

    private fun updateRank(rank: Rank) {
        when (rank) {
            Rank.FIRST -> first++
            Rank.SECOND -> second++
            Rank.THIRD -> third++
            Rank.FOURTH -> fourth++
            Rank.FIFTH -> fifth++
            Rank.MISS -> {}
        }
    }

    enum class RateResult(val koreanText: String) {
        WIN("이익"),
        LOSS("손해"),
    }

    companion object {
        const val TICKET_PRICE = 1_000
    }
}
