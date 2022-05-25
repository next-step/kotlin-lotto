package lotto.view

import lotto.domain.InputValidator
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object InputView {
    private const val LOTTO_LIST_DELIMITER = ","
    private const val LOTTO_ANSWER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요"
    private const val MONEY_INPUT_MESSAGE = "구매금액을 입력해 주세요."

    fun getUserMoney(): Int {
        var moneyInput: String
        do {
            moneyInput = getUserInputWithMessage(MONEY_INPUT_MESSAGE)
        } while (isValidMoney(moneyInput).not())

        return moneyInput.toInt()
    }

    private fun isValidMoney(money: String): Boolean {
        return try {
            InputValidator.checkIsValidMoney(money)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    private fun getUserInputWithMessage(msg: String): String {
        println(msg)
        return readln()
    }

    fun getLottoAnswer(): LottoNumbers {
        var lottoInput: String
        do {
            lottoInput = getUserInputWithMessage(LOTTO_ANSWER_INPUT_MESSAGE)
        } while (isValidLottoAnswer(lottoInput).not())

        return LottoNumbers(lottoInput.split(LOTTO_LIST_DELIMITER).map { LottoNumber(it.toInt()) })
    }

    private fun isValidLottoAnswer(lotto: String): Boolean {
        return try {
            InputValidator.checkValidLotto(lotto)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }
}
