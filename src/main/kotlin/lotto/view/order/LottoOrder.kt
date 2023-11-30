package lotto.view.order

import lotto.model.LottoTicket
import lotto.view.OutputView
import lotto.view.order.impl.LottoAutomaticOrderStrategy
import lotto.view.order.impl.LottoManualOrderStrategy

class LottoOrder(
    private val totalCount: Int,
    private val manualCount: Int,
    private val autoCount: Int,
) {
    constructor(totalAmount: Int, manualCount: Int) : this(
        totalCount = totalAmount / PRICE_PER_LOTTO_GAME,
        manualCount = manualCount,
        autoCount = (totalAmount / PRICE_PER_LOTTO_GAME) - manualCount
    )

    fun ticketing(): LottoTicket {
        requireCountCheck()
        val lottoTicket = issue(manualCount, LottoManualOrderStrategy) +
            issue(autoCount, LottoAutomaticOrderStrategy)
        OutputView.confirmTicketTypeCount(manualCount, autoCount)
        return lottoTicket
    }

    private fun requireCountCheck() {
        require(totalCount >= manualCount) { "수동 구매 수량이 너무 많습니다" }
    }

    private fun issue(count: Int, strategy: LottoOrderStrategy): LottoTicket {
        return LottoTicket(strategy.issue(count))
    }

    fun pricePerGame(): Int {
        return PRICE_PER_LOTTO_GAME
    }

    companion object {
        private const val PRICE_PER_LOTTO_GAME = 1000
    }
}
