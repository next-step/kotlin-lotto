package lotto.view.input

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberPackage
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoPurchaseCount

class ConsoleInputView : InputView {
    override fun getPurchaseAmount(): LottoPurchaseAmount {
        println(RECEIVE_PURCHASE_AMOUNT_MESSAGE)
        return LottoPurchaseAmount.from(readLine() ?: "")
    }

    override fun getManualPurchaseCount(): LottoPurchaseCount {
        println(RECEIVE_MANUAL_PURCHASE_COUNT_MESSAGE)
        return LottoPurchaseCount.from(readLine() ?: "")
    }

    override fun getManualNumbers(manualPurchaseCount: LottoPurchaseCount): List<LottoNumberPackage> {
        println(RECEIVE_MANUAL_NUMBERS_MESSAGE)
        return IntRange(1, manualPurchaseCount.value)
            .map { LottoNumberPackage.from(readLine() ?: "") }
            .toList()
    }

    override fun getWinningNumbers(): LottoNumberPackage {
        println("\n" + RECEIVE_WINNING_NUMBERS_MESSAGE)
        return LottoNumberPackage.from(readLine() ?: "")
    }

    override fun getBonusNumber(winningNumbers: LottoNumberPackage): LottoNumber {
        println(RECEIVE_BONUS_NUMBER_MESSAGE)
        return LottoNumber.from(readLine() ?: "", winningNumbers)
    }

    companion object {
        private const val RECEIVE_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val RECEIVE_MANUAL_PURCHASE_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val RECEIVE_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
        private const val RECEIVE_WINNING_NUMBERS_MESSAGE = "지난 주 당첨번호를 입력해 주세요."
        private const val RECEIVE_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
    }
}
