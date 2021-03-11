package lotto.model.game

import lotto.model.input.InputReader
import lotto.model.input.Money
import lotto.model.result.Result
import java.math.BigDecimal

class LottoGame(private val lottoMachine: LottoMachine, private val inputReader: InputReader) {
    var totalCount: Int = 0
        private set

    fun ready(money: Money): Int {
        totalCount = lottoMachine.insertMoney(money)
        return totalCount
    }

    fun selectByManual(manualCount: Int): Lottos {
        require(manualCount <= totalCount) { "예산으로 구매가 불가능한 갯수입니다." }

        val lottos = (1..manualCount)
            .map { inputReader.readLottoNumbers() }

        val lottoByManual = Lottos(lottos)
        lottoMachine.buyByManual(lottoByManual)

        return lottoByManual
    }

    fun buy(lottoCount: Int): Lottos {
        require(totalCount >= lottoCount) { "예산으로 구매가 불가능한 갯수입니다." }
        return lottoMachine.buy(lottoCount)
    }

    fun getResult(winningLotto: WinningLotto): List<Result> {
        return lottoMachine.getResult(winningLotto)
    }

    fun getEarningRate(): BigDecimal {
        return lottoMachine.getEarningRate()
    }

    fun selectWinningLotto(): Lotto {
        return inputReader.readLottoNumbers()
    }

    fun selectBonusBall(winningNumbers: Lotto): LottoNumber {
        return inputReader.readBonusNumber(winningNumbers)
    }
}
