package lotto.view.inputView

import lotto.domain.LottoNumber
import lotto.domain.Money

class LottoInputView : InputView {
    override fun receiveMoney(): Money {
        println(RECEIVE_MONEY_MSG)
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MSG }
        return Money(input.toInt())
    }

    override fun receiveWinningNumbers(): List<LottoNumber> {
        println(RECEIVE_WINNING_NUMBERS_MSG)
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MSG }
        return input.split(",").map { LottoNumber(it.toInt()) }
    }

    companion object {
        private const val RECEIVE_MONEY_MSG = "구입금액을 입력해 주세요."
        private const val RECEIVE_WINNING_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요."
        private const val EMPTY_STRING_ERROR_MSG = "입력이 비어있습니다."
    }
}
