package lotto.model

import lotto.view.InputView
import java.math.BigDecimal

class LottoGame(private val lottoMachine: LottoMachine, private val inputReader: InputReader) {
    fun ready(): Int {
        InputView.printBudgetQuestion()
        val budget: Money = inputReader.readBudget()
        return lottoMachine.insertMoney(budget)
    }

    fun buy(): Lottos {
        return lottoMachine.buy()
    }

    fun getResult(): List<Result> {
        val winningLotto = selectWinningLotto()
        return lottoMachine.getResult(winningLotto)
    }

    fun getEarningRate(): BigDecimal {
        return lottoMachine.getEarningRate()
    }

    private fun selectWinningLotto(): WinningLotto {
        InputView.printWinningNumberQuestion()
        val winningNumbers: Lotto = inputReader.readWinningLottoNumbers()

        InputView.printBonusBallQuestion()
        val bonusNumber: LottoNumber = inputReader.readBonusNumber(winningNumbers)
        return WinningLotto(winningNumbers, bonusNumber)
    }
}
