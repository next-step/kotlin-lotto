package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoValidator
import lotto.presentation.InputManager
import lotto.presentation.OutputManager

class LottoStore(
    private val inputManager: InputManager,
    private val outputManager: OutputManager
) {
    private val lottoMachine: LottoMachine = LottoMachine(LOTTO_PRICE)
    fun start() {
        val userPay = inputManager.inputPay()
        outputManager.printUserPay(userPay)

        val userLottos = lottoMachine.sellLotto(userPay)
        outputManager.printSellLottoCount(userLottos)

        val winningNumbers: List<Int> = inputManager.inputWinningNumber()
        lottoMachine.setWinningNumber(winningNumbers)

        val result = checkLottoResult(userLottos, lottoMachine.getWinningNumber())
        outputManager.printResult(result)
    }

    private fun checkLottoResult(
        userLottos: List<Lotto>,
        winningNumber: List<LottoNumber>
    ): LottoResult {
        val lottoResult = LottoResult()
        userLottos.forEach {
            val matchedNumberCount = LottoValidator.validateWinningNumberAndUserLotto(winningNumber, it)
            lottoResult.setLottoResult(matchedNumberCount)
        }
        return lottoResult
    }

    companion object {
        private const val LOTTO_PRICE: Int = 1000
    }
}

fun main() {
    LottoStore(InputManager(), OutputManager()).start()
}
