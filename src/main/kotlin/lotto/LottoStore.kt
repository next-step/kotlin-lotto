package lotto

import lotto.domain.LottoMachine
import lotto.domain.WinningLotto
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

        val winningNumbers = WinningLotto.create(inputManager.inputWinningNumber())
        val result = winningNumbers.match(userLottos)
        outputManager.printResult(result)

        val revenue = result.calcRate(LOTTO_PRICE, userLottos.size)
        outputManager.printRevenue(revenue)
    }

    companion object {
        private const val LOTTO_PRICE: Int = 1000
    }
}

fun main() {
    LottoStore(InputManager(), OutputManager()).start()
}
