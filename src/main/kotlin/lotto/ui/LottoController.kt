package lotto.ui

import lotto.domain.*

object LottoController {
    fun purchaseLottos(purchasePrice: Int): List<Lotto> {
        return Store.purchase(purchasePrice)
    }

    fun drawWinningLottos(winningLottoNumbers: Set<LottoNumber>, bonusNumber: LottoNumber): WinningLotto {
        return WinningLotto(
            Lotto(winningLottoNumbers),
            bonusNumber
        )
    }

    fun getRoundResult(purchasedLottos: List<Lotto>, winningLotto: WinningLotto): RoundResult {
        return Round(purchasedLottos, winningLotto).aggregate()
    }

    fun calculateEarningRate(roundResult: RoundResult): Double {
        return roundResult.calculateEarningRate()
    }
}
