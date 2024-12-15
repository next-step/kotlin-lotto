package lotto.controller

import lotto.domain.LottoResults
import lotto.domain.LottoTickets
import lotto.domain.WinningLotto

object LottoController {
    fun purchaseLotto(amount: Int): LottoTickets {
        return LottoTickets.purchase(amount)
    }

    fun calculateLottoRank(
        lottoTickets: LottoTickets,
        winningLotto: WinningLotto,
    ): LottoResults {
        return lottoTickets.calculateLottoRank(winningLotto)
    }
}
