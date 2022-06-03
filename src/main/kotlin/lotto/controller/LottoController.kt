package lotto.controller

import lotto.domain.LottoBendingMachine
import lotto.domain.LottoYieldCalculator
import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.RangeLottoFactory
import lotto.domain.model.UserInputRequest
import lotto.domain.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.inputconverter.LottoConverter
import lotto.view.inputconverter.LottoNumberConverter
import lotto.view.inputconverter.StringToIntConverter
import lotto.view.outputconverter.LottoResultConverter
import lotto.view.outputconverter.LottoYieldConverter
import lotto.view.outputconverter.LottosConverter

object LottoController {
    private const val GUIDANCE_MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요."
    private const val GUIDANCE_MESSAGE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val GUIDANCE_MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요."

    fun execute() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = LottoBendingMachine.purchase(purchaseAmount, RangeLottoFactory(LottoNumber.LOTTO_NUMBER_RANGE))
        OutputView.println(
            printable = lottos,
            outputConverter = LottosConverter
        )

        val winningNumbers = getWinningNumbers()
        val bonusBall = getBonusBall()
        val lottoResult = lottos.checkWith(WinningNumbers(winningNumbers, bonusBall))
        OutputView.print(
            printable = lottoResult,
            outputConverter = LottoResultConverter
        )

        val lottoYield = LottoYieldCalculator.calculate(lottoResult, purchaseAmount)
        OutputView.print(
            printable = lottoYield,
            outputConverter = LottoYieldConverter
        )
    }

    private fun getPurchaseAmount(): Int {
        val userInputRequest = UserInputRequest(
            message = GUIDANCE_MESSAGE_PURCHASE_AMOUNT,
            inputConverter = StringToIntConverter
        )

        return InputView.receiveUserInput(userInputRequest)
    }

    private fun getWinningNumbers(): Lotto {
        val userInputRequest = UserInputRequest(
            message = GUIDANCE_MESSAGE_WINNING_NUMBERS,
            inputConverter = LottoConverter
        )

        return InputView.receiveUserInput(userInputRequest)
    }

    private fun getBonusBall(): LottoNumber {
        val userInputRequest = UserInputRequest(
            message = GUIDANCE_MESSAGE_BONUS_BALL,
            inputConverter = LottoNumberConverter
        )

        return InputView.receiveUserInput(userInputRequest)
    }
}
