package lotto.view.input

import lotto.domain.LottoPurchaseAmount
import lotto.domain.WinningInfo

class ConsoleInputView : InputView {
    override fun getPurchaseAmount(): LottoPurchaseAmount {
        println(RECEIVE_PURCHASE_AMOUNT_MESSAGE)
        return LottoPurchaseAmount.from(readLine() ?: "")
    }

    override fun getWonNumbers(): WinningInfo {
        println(RECEIVE_WON_NUMBERS_MESSAGE)
        return WinningInfo(WinningInfo.from(readLine() ?: ""))
    }

    companion object {
        private const val RECEIVE_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val RECEIVE_WON_NUMBERS_MESSAGE = "지난 주 당첨번호를 입력해 주세요."
    }
}
