package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Round
import lotto.domain.RoundResult
import lotto.domain.Store
import lotto.domain.Ticket
import lotto.domain.WinningLotto

object LottoController {
    fun purchaseTicket(purchasePrice: Int, lottoNumbersList: List<Set<LottoNumber>>): Ticket {
        return Ticket(purchasePrice, lottoNumbersList)
    }

    fun issueLottos(ticket: Ticket): Lottos {
        val autoLottos = Store.purchaseAutoLottos(ticket)
        val manualLottos = Store.purchaseManualLotto(ticket)

        return autoLottos + manualLottos
    }

    fun drawWinningLottos(winningLottoNumbers: Set<LottoNumber>, bonusNumber: LottoNumber): WinningLotto {
        return WinningLotto(
            Lotto(winningLottoNumbers),
            bonusNumber
        )
    }

    fun getRoundResult(purchasedLottos: Lottos, winningLotto: WinningLotto): RoundResult {
        return Round(purchasedLottos, winningLotto).aggregate()
    }

    fun calculateEarningRate(roundResult: RoundResult): Double {
        return roundResult.calculateEarningRate()
    }
}
