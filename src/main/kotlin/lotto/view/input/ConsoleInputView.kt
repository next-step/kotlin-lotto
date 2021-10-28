package lotto.view.input

import lotto.domain.*

class ConsoleInputView : InputView {
    override fun getPurchaseAmount(): LottoPurchaseAmount {
        println(RECEIVE_PURCHASE_AMOUNT_MESSAGE)
        return LottoPurchaseAmount.from(readLine() ?: "")
    }

    override fun getWinningNumbers(): WinningInfo {
        println("\n" + RECEIVE_WINNING_NUMBERS_MESSAGE)
        return WinningInfo(WinningInfo.from(readLine() ?: ""))
    }

    override fun getBonusNumber(winningNumbers: LottoNumberPackage): LottoNumber {
        println(RECEIVE_BONUS_NUMBER_MESSAGE)
        return BonusNumber.from(readLine() ?: "", winningNumbers)
    }

    companion object {
        private const val RECEIVE_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val RECEIVE_WINNING_NUMBERS_MESSAGE = "지난 주 당첨번호를 입력해 주세요."
        private const val RECEIVE_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
    }
}
