package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money

object LottoInputView {
    private const val WINNING_LOTTO_DELIMITER = ","

    fun inputMoney(): Money {
        return Money(readLineWithMessage("구입금액을 입력해 주세요.").trim().toInt())
    }

    fun inputWinningLottoNumbers(): LottoNumbers {
        return readLineWithMessage("지난 주 당첨 번호를 입력해 주세요.")
            .split(WINNING_LOTTO_DELIMITER)
            .map { it.trim().toInt() }
            .let { LottoNumbers.from(it.toSet()) }
    }

    fun inputBonusNumber(): LottoNumber {
        return LottoNumber(readLineWithMessage("보너스 볼을 입력해 주세요.").trim().toInt())
    }

    private fun readLineWithMessage(message: String): String {
        println(message)
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    }
}
