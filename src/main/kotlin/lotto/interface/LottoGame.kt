package lotto.`interface`

import lotto.domain.Lotto
import lotto.domain.LottoStatistics
import lotto.domain.WinningNumber
import lotto.usecase.LottoMachine
import lotto.usecase.WinningsChecker

class LottoGame(
    private val lottoMachine: LottoMachine,
    private val winningsChecker: WinningsChecker,
) {

    fun buy(purchaseAmount: Int): List<Lotto> {
        return lottoMachine.buy(purchaseAmount)
    }

    fun confirmWinning(
        winningNumbers: List<Int>,
        lottos: List<Lotto>,
    ): LottoStatistics {
        val winningNumber = WinningNumber(winningNumbers)

        return winningsChecker.check(
            lottos = lottos,
            winningNumber = winningNumber
        )
    }
}
