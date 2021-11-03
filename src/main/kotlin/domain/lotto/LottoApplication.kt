package domain.lotto

import domain.lotto.domain.Lotto
import domain.lotto.domain.LottoNumber
import domain.lotto.domain.Money
import domain.lotto.domain.WinningLotto
import domain.lotto.service.LottoService
import domain.lotto.strategy.LottoRandomShuffleStrategy
import domain.lotto.ui.LottoInputView
import domain.lotto.ui.LottoResultView
import global.common.ui.ExceptionView
import global.strategy.split.CommaSplitStrategy
import global.strategy.ui.ConsoleInputStrategy
import global.strategy.ui.ConsoleOutputStrategy

class LottoApplication(
    private val lottoInputView: LottoInputView,
    private val lottoResultView: LottoResultView,
    private val exceptionView: ExceptionView
) {
    fun run() {
        val money = purchaseLottoByConsole()
        lottoResultView.showNumberOfPurchases(money.numberOfPurchases(Lotto.PRICE))
        val lottos = LottoService.lottos(money, LottoRandomShuffleStrategy)
        lottoResultView.showLottos(lottos)

        val winningLotto = winningLottoByConsole()
        val matchResult = LottoService.match(lottos, winningLotto)
        lottoResultView.showMatchResult(matchResult)
        lottoResultView.showYield(money, Money(matchResult.winnings()))
    }

    private fun winningLottoByConsole(): WinningLotto {
        return try {
            WinningLotto.from(lottoByConsole(), bonusBallByConsole())
        } catch (e: Exception) {
            exceptionView.output(e.message.toString())
            winningLottoByConsole()
        }
    }

    private fun purchaseLottoByConsole(): Money {
        return try {
            Money(lottoInputView.purchaseLotto())
        } catch (e: Exception) {
            exceptionView.output(e.message.toString())
            purchaseLottoByConsole()
        }
    }

    private fun lottoByConsole(): Lotto {
        return try {
            Lotto.of(lottoInputView.winningLotto(), CommaSplitStrategy)
        } catch (e: Exception) {
            exceptionView.output(e.message.toString())
            lottoByConsole()
        }
    }

    private fun bonusBallByConsole(): LottoNumber {
        return try {
            LottoNumber.of(lottoInputView.bonusBall())
        } catch (e: Exception) {
            exceptionView.output(e.message.toString())
            bonusBallByConsole()
        }
    }
}

fun main() {
    val lottoInputView = LottoInputView(ConsoleInputStrategy, ConsoleOutputStrategy)
    val lottoResultView = LottoResultView(ConsoleOutputStrategy)
    val exceptionView = ExceptionView(ConsoleOutputStrategy)
    val lottoApplication = LottoApplication(lottoInputView, lottoResultView, exceptionView)
    lottoApplication.run()
}
