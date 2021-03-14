package lotto.controller

import lotto.model.game.LottoNumber
import lotto.model.game.WinningLotto
import lotto.model.game.Lotto
import lotto.model.game.LottoGame
import lotto.model.game.Lottos
import lotto.model.result.Coincidence
import lotto.model.result.Result
import lotto.view.InputView
import java.math.BigDecimal

class LottoGameController(private val lottoGame: LottoGame) {
    fun ready(): Int {
        InputView.printBudgetQuestion()
        val budget: Int = InputView.getBudget()

        return lottoGame.ready(budget)
    }

    fun buy(totalCount: Int): Lottos {
        InputView.printManualCountQuestion()
        val manualCount = InputView.getManualCount(totalCount)
        val autoCount = totalCount - manualCount

        InputView.printManualNumberQuestion()
        val manualNumbers = InputView.getLottoNumbersByManual(manualCount)

        return lottoGame.buy(autoCount, manualNumbers)
    }

    fun getWinningLotto(): WinningLotto {
        InputView.printWinningNumberQuestion()
        val winningNumbers = InputView.readLottoNumbers()

        InputView.printBonusBallQuestion()
        val bonusNumber = InputView.readBonusNumber()

        return WinningLotto(Lotto(winningNumbers), LottoNumber(bonusNumber))
    }

    fun match(lottos: Lottos, winningLotto: WinningLotto): Map<Coincidence, Result> {
        return lottoGame.getResult(lottos, winningLotto)
    }

    fun getEarningRate(lottos: Lottos, winningLotto: WinningLotto): BigDecimal {
        return lottos.getEarningRate(winningLotto.winningLotto)
    }
}
