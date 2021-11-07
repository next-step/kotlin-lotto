package domain.lotto

import domain.lotto.domain.Lotto
import domain.lotto.domain.LottoNumber
import domain.lotto.domain.Lottos
import domain.lotto.domain.Money
import domain.lotto.domain.TicketCount
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
        val lottoPurchaseTicket = TicketCount(money.numberOfPurchases(Lotto.PRICE))
        if (lottoPurchaseTicket.ticketCount == TicketCount.MINIMUM) {
            return lottoResultView.showNoHaveTicketResult()
        }
        val manuallyPurchaseTicket = manuallyPurchaseLottoByConsole(lottoPurchaseTicket)
        val manuallyLottos = manuallyLottosByConsole(lottoPurchaseTicket, manuallyPurchaseTicket)
        val automaticallyLottos =
            LottoService.automaticallyLottos(manuallyPurchaseTicket.ticketCount, LottoRandomShuffleStrategy)

        val lottos = manuallyLottos + automaticallyLottos
        lottoResultView.showLottos(lottos)
        val winningLotto = winningLottoByConsole()
        val matchResult = LottoService.match(lottos, winningLotto)
        lottoResultView.showMatchResult(matchResult)
        lottoResultView.showYield(money, Money(matchResult.winnings()))
    }

    private fun manuallyPurchaseLottoByConsole(standardTicketCount: TicketCount): TicketCount {
        return try {
            val manuallyTicket = TicketCount(lottoInputView.manuallyPurchaseLotto())
            return standardTicketCount.subtract(manuallyTicket)
        } catch (e: Exception) {
            exceptionView.showErrorMessage(e.message.toString())
            manuallyPurchaseLottoByConsole(standardTicketCount)
        }
    }

    private fun manuallyLottosByConsole(standardTicketCount: TicketCount, availableTicketCount: TicketCount): Lottos {
        return try {
            val manuallyTicket = standardTicketCount.subtract(availableTicketCount)
            if (manuallyTicket.ticketCount == TicketCount.MINIMUM) {
                return Lottos.empty()
            }
            Lottos.of(
                lottoInputView.manuallyLottos(manuallyTicket.ticketCount)
                    .map { Lotto.of(it, CommaSplitStrategy) }
                    .toList()
            )
        } catch (e: Exception) {
            exceptionView.showErrorMessage(e.message.toString())
            manuallyLottosByConsole(standardTicketCount, availableTicketCount)
        }
    }

    private fun winningLottoByConsole(): WinningLotto {
        return try {
            WinningLotto.from(lottoByConsole(), bonusBallByConsole())
        } catch (e: Exception) {
            exceptionView.showErrorMessage(e.message.toString())
            winningLottoByConsole()
        }
    }

    private fun purchaseLottoByConsole(): Money {
        return try {
            Money(lottoInputView.purchaseLotto())
        } catch (e: Exception) {
            exceptionView.showErrorMessage(e.message.toString())
            purchaseLottoByConsole()
        }
    }

    private fun lottoByConsole(): Lotto {
        return try {
            Lotto.of(lottoInputView.winningLotto(), CommaSplitStrategy)
        } catch (e: Exception) {
            exceptionView.showErrorMessage(e.message.toString())
            lottoByConsole()
        }
    }

    private fun bonusBallByConsole(): LottoNumber {
        return try {
            LottoNumber.of(lottoInputView.bonusBall())
        } catch (e: Exception) {
            exceptionView.showErrorMessage(e.message.toString())
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
