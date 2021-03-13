package lotto.model.game

import lotto.view.InputReader
import lotto.model.result.Result
import java.math.BigDecimal

class LottoGame(private val lottoMachine: LottoMachine, val inputReader: InputReader) {
    var totalCount: Int = 0
        private set

    fun ready(): Int {
        totalCount = lottoMachine.insertMoney(inputReader.readBudget())
        return totalCount
    }

    fun selectByManual(manualCount: Int): Lottos {
        require(manualCount <= totalCount) { "예산으로 구매가 불가능한 갯수입니다." }

        val lottoByManual = Lottos(getLottoNumbersByManual(manualCount))
        lottoMachine.buyByManual(lottoByManual)

        return lottoByManual
    }

    fun buyByAuto(manualCount: Int): Lottos {
        require(totalCount >= manualCount) { "예산으로 구매가 불가능한 갯수입니다." }
        return lottoMachine.buy(totalCount - manualCount)
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

    private fun getLottoNumbersByManual(manualCount: Int): List<Lotto> {
        return (ONE..manualCount)
            .map { inputReader.readLottoNumbers() }
    }

    companion object {
        private const val ONE = 1
    }
}
