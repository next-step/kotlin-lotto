package lotto.model.issue

import lotto.model.Game
import lotto.model.LottoOrder
import lotto.model.LottoTicket
import lotto.model.strategy.LottoNumberStrategy

class LottoIssueMachineAuto(
    val strategy: LottoNumberStrategy,
) : LottoIssueMachine {
    override fun buy(lottoOrder: LottoOrder): LottoTicket {
        return LottoTicket(
            List(autoIssueCount(lottoOrder)) { Game.of(strategy) }
        )
    }

    private fun autoIssueCount(lottoOrder: LottoOrder): Int {
        return lottoOrder.totalPurchaseCount - lottoOrder.manualIssuedGames.size
    }
}
