package lotto.model.game

import lotto.model.input.InputReader
import lotto.model.input.Money
import lotto.model.result.Result
import lotto.view.InputView
import java.math.BigDecimal

class LottoGame(private val lottoMachine: LottoMachine, private val inputReader: InputReader) {
    var totalCount: Int = 0
        private set

    fun ready(money: Money): Int {
        totalCount = lottoMachine.insertMoney(money)
        return totalCount
    }

    fun selectByManual(manualCount: Int): Lottos {
        TODO("Not yet implemented")
    }

    fun buy(lottoCount: Int): Lottos {
        require(totalCount >= lottoCount) { "예산으로 구매가 불가능한 갯수입니다." }
        return lottoMachine.buy(lottoCount)
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
        val winningNumbers: Lotto = inputReader.readLottoNumbers()

        InputView.printBonusBallQuestion()
        val bonusNumber: LottoNumber = inputReader.readBonusNumber(winningNumbers)
        return WinningLotto(winningNumbers, bonusNumber)
    }
}
