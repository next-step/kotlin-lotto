package lotto.view.inputView

import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.WinningLotto

class LottoInputView {
    fun receiveMoney(): Money {
        println(RECEIVE_MONEY_MSG)
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MSG }
        return Money(input.toInt())
    }

    fun receiveWinningLotto(): WinningLotto {
        val winningNumbers = receiveWinningNumbers()
        val bonusNumber = receiveBonusNumber()
        return WinningLotto(winningNumbers, bonusNumber)
    }

    private fun receiveWinningNumbers(): List<LottoNumber> {
        println(RECEIVE_WINNING_NUMBERS_MSG)
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MSG }
        return input
            .filter { !it.isWhitespace() }
            .split(",")
            .map { LottoNumber(it.toInt()) }
    }

    private fun receiveBonusNumber(): LottoNumber {
        println(RECEIVE_BONUS_NUMBER_MSG)
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MSG }
        return LottoNumber(input.toInt())
    }

    companion object {
        private const val RECEIVE_MONEY_MSG = "구입금액을 입력해 주세요."
        private const val RECEIVE_WINNING_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요."
        private const val RECEIVE_BONUS_NUMBER_MSG = "보너스 볼을 입력해 주세요."
        private const val EMPTY_STRING_ERROR_MSG = "입력이 비어있습니다."
    }
}
