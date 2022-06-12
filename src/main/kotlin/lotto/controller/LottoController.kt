package lotto.controller

import lotto.domain.LottoBendingMachine
import lotto.domain.LottoYieldCalculator
import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoReceipt
import lotto.domain.model.Lottos
import lotto.domain.model.Money
import lotto.domain.model.PurchaseCount
import lotto.domain.model.RangeLottoFactory
import lotto.domain.model.TotalLottoReceipt
import lotto.domain.model.UserInputRequest
import lotto.domain.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.inputconverter.LottoConverter
import lotto.view.inputconverter.LottoNumberConverter
import lotto.view.inputconverter.MoneyConverter
import lotto.view.inputconverter.PurchaseCountConverter
import lotto.view.outputconverter.LottoResultConverter
import lotto.view.outputconverter.LottoYieldConverter
import lotto.view.outputconverter.TotalLottoReceiptConverter

object LottoController {
    private const val GUIDANCE_MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요."
    private const val GUIDANCE_MESSAGE_MANUAL_LOTTO_PURCHASE_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val GUIDANCE_MESSAGE_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요."
    private const val GUIDANCE_MESSAGE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val GUIDANCE_MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요."

    fun execute() {
        val purchaseAmount = getPurchaseAmount()
        val maximumPurchaseCount = PurchaseCount.of(purchaseAmount, LottoBendingMachine.LOTTO_PRICE)
        val manualLottoReceipt = getManualLottoReceipt(maximumPurchaseCount)

        val automaticLottoPurchaseAmount = getAutomaticLottoPurchaseAmount(
            manualLottoPurchaseCount = manualLottoReceipt.purchaseCount,
            totalPurchaseAmount = purchaseAmount
        )

        val automaticLottoReceipt = LottoBendingMachine.purchaseAutomaticLottos(
            purchaseAmount = automaticLottoPurchaseAmount,
            lottoFactory = RangeLottoFactory(LottoNumber.LOTTO_NUMBER_RANGE)
        )

        val totalLottoReceipt = TotalLottoReceipt(manualLottoReceipt, automaticLottoReceipt)
        OutputView.println(
            printable = totalLottoReceipt,
            outputConverter = TotalLottoReceiptConverter
        )

        val winningNumbers = WinningNumbers(getWinningNumbers(), getBonusBall())
        val lottoResult = winningNumbers.checkWith(totalLottoReceipt.lottos)
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

    private fun getPurchaseAmount(): Money {
        val userInputRequest = UserInputRequest(
            message = GUIDANCE_MESSAGE_PURCHASE_AMOUNT,
            inputConverter = MoneyConverter
        )

        return InputView.receiveUserInput(userInputRequest)
    }

    private fun getManualLottoReceipt(maximumPurchaseCount: PurchaseCount): LottoReceipt {
        val purchaseCount = getManualLottoPurchaseCount(maximumPurchaseCount)
        val lottos = getManualLottos(purchaseCount)

        return LottoReceipt(purchaseCount, lottos)
    }

    private fun getManualLottoPurchaseCount(maximum: PurchaseCount): PurchaseCount {
        val userInputRequest = UserInputRequest(
            message = GUIDANCE_MESSAGE_MANUAL_LOTTO_PURCHASE_COUNT,
            inputConverter = PurchaseCountConverter
        )

        val receivedPurchaseCount = InputView.receiveUserInput(userInputRequest)

        return receivedPurchaseCount.coerceAtMost(maximum)
    }

    private fun getManualLottos(purchaseCount: PurchaseCount): Lottos {
        if (purchaseCount.value == 0) return Lottos.empty()

        InputView.printGuidanceMessage(GUIDANCE_MESSAGE_MANUAL_LOTTO_NUMBERS)

        val userInputRequest = UserInputRequest(
            message = "",
            inputConverter = LottoConverter
        )

        val lottos = List(purchaseCount.value) {
            InputView.receiveUserInputWithoutMessage(userInputRequest)
        }

        return Lottos.from(lottos)
    }

    private fun getAutomaticLottoPurchaseAmount(
        manualLottoPurchaseCount: PurchaseCount,
        totalPurchaseAmount: Money
    ): Money {
        val manualLottosPrice = Money.of(manualLottoPurchaseCount, LottoBendingMachine.LOTTO_PRICE)
        return totalPurchaseAmount - manualLottosPrice
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
