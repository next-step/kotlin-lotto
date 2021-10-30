package domain.lotto

import domain.lotto.domain.Lotto
import domain.lotto.domain.Money
import domain.lotto.service.LottoService
import domain.lotto.ui.LottoInputView
import domain.lotto.ui.LottoResultView
import global.strategy.ConsoleInputStrategy
import global.strategy.ConsoleOutputStrategy

class LottoApplication(
    private val lottoInputView: LottoInputView,
    private val lottoResultView: LottoResultView
) {
    fun run() {
        val money = purchaseLottoByConsole()
        lottoResultView.announceNumberOfPurchases(money.numberOfPurchases(Lotto.PRICE))
        val result = LottoService.run(money)
    }

    private fun purchaseLottoByConsole(): Money {
        return try {
            Money(lottoInputView.purchaseLotto())
        } catch (e: Exception) {
            ConsoleOutputStrategy.output(e.message.toString())
            purchaseLottoByConsole()
        }
    }
}

fun main() {
    val lottoInputView = LottoInputView(ConsoleInputStrategy, ConsoleOutputStrategy)
    val lottoResultView = LottoResultView(ConsoleOutputStrategy)
    val lottoApplication = LottoApplication(lottoInputView, lottoResultView)
    lottoApplication.run()
}
