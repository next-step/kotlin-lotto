package lotto.controller

import lotto.domain.LottoBendingMachine
import lotto.domain.YieldCalculator
import lotto.domain.model.UserInputRequest
import lotto.domain.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.inputconverter.StringToIntConverter
import lotto.view.inputconverter.WinningNumbersConverter
import lotto.view.outputconverter.LottoResultConverter
import lotto.view.outputconverter.LottosConverter
import lotto.view.outputconverter.YieldConverter

object LottoController {
    private const val GUIDANCE_MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요."
    private const val GUIDANCE_MESSAGE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."

    fun execute() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = LottoBendingMachine.purchase(purchaseAmount)
        OutputView.println(
            printable = lottos,
            outputConverter = LottosConverter
        )

        val winningNumbers = getWinningNumbers()
        val lottoResult = lottos.checkWith(winningNumbers)
        OutputView.print(
            printable = lottoResult,
            outputConverter = LottoResultConverter
        )

        val `yield` = YieldCalculator.calculate(lottoResult, purchaseAmount)
        OutputView.print(
            printable = `yield`,
            outputConverter = YieldConverter
        )
    }

    private fun getPurchaseAmount(): Int {
        val userInputRequest = UserInputRequest(
            message = GUIDANCE_MESSAGE_PURCHASE_AMOUNT,
            inputConverter = StringToIntConverter
        )

        return InputView.receiveUserInput(userInputRequest)
    }

    private fun getWinningNumbers(): WinningNumbers {
        val userInputRequest = UserInputRequest(
            message = GUIDANCE_MESSAGE_WINNING_NUMBERS,
            inputConverter = WinningNumbersConverter
        )

        return InputView.receiveUserInput(userInputRequest)
    }
}
