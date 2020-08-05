package lotto

import lotto.domain.Lotto
import lotto.domain.generator.ManualLottoGenerator
import lotto.domain.selling.Seller
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    private val seller = Seller()

    @JvmStatic
    fun main(args: Array<String>) {
        val money = InputView.readMoney { seller.isAcceptable(it) }.toInt()
        val result = seller.processOrder(money)
        ResultView.printPaymentResult(result)

        // 결과 출력
        val numbers = InputView.readWinningNumbers { ManualLottoGenerator.isAcceptable(it) }
        val winningNumbers = Lotto(ManualLottoGenerator(numbers))
        println(winningNumbers.numbers.joinToString())
    }
}
