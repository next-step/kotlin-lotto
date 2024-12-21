package lotto.domain

import lotto.domain.LottoResult.RateResult.LOSS
import lotto.domain.LottoResult.RateResult.WIN
import lotto.domain.LottoTicket.Companion.TICKET_PRICE
import kotlin.math.roundToInt

class LottoResult(tickets: List<LottoTicket>, win: LottoWinner, used: Int = 0) {
    var rankMap: Map<Rank, Int> = mutableMapOf()
        private set
    private var totalCount: Int = used

    private val totalPrize by lazy {
        rankMap.map {
            it.value * it.key.winningMoney
        }.sum()
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
        rankMap += (rank to (rankMap[rank] ?: 0) + 1)
    }

    enum class RateResult(val koreanText: String) {
        WIN("이익"),
        LOSS("손해"),
    }
}
