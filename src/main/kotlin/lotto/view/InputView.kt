package lotto.view

import lotto.domain.InputValidator

object InputView {
    private const val LOTTO_LIST_DELIMITER = ","
    private const val LOTTO_ANSWER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요"
    private const val MONEY_INPUT_MESSAGE = "구매금액을 입력해 주세요."
    private const val LOTTO_BONUS_BALL_MESSAGE = "보너스볼을 입력해 주세요"

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

    fun getLottoAnswer(): List<Int> {
        var lottoInput: String
        do {
            lottoInput = getUserInputWithMessage(LOTTO_ANSWER_INPUT_MESSAGE)
        } while (isValidLottoAnswer(lottoInput).not())

        return lottoInput.split(LOTTO_LIST_DELIMITER).map { it.toInt() }
    }

    fun getBonusBall(): Int {
        var lottoBonusInput: String
        do {
            lottoBonusInput = getUserInputWithMessage(LOTTO_BONUS_BALL_MESSAGE)
        } while (isValidLottoBonusBall(lottoBonusInput).not())

        return lottoBonusInput.toInt()
    }

    private fun isValidLottoBonusBall(lotto: String): Boolean {
        return try {
            InputValidator.checkValidBonusBall(lotto)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
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
