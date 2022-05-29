package lotto.view

import lotto.domain.InputValidator

object InputView {
    private const val LOTTO_LIST_DELIMITER = ","
    const val LOTTO_ANSWER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요\n"
    private const val MONEY_INPUT_MESSAGE = "구매금액을 입력해 주세요.\n"
    private const val LOTTO_BONUS_BALL_MESSAGE = "보너스볼을 입력해 주세요\n"
    private const val LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요\n"
    private const val LOTTO_MANUAL_MESSAGE = "수동으로 구매할 번호를 입력해 주세요\n"

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
        print(msg)
        return readln()
    }

    fun getLottoNumbers(count: Int): List<List<Int>> {
        print(LOTTO_MANUAL_MESSAGE)
        val lottos = mutableListOf<List<Int>>()
        repeat(count) {
            val lottoNumbers = getLottoNumbers()

            lottos.add(lottoNumbers)
        }

        return lottos
    }

    fun getLottoNumbers(msg: String = ""): List<Int> {
        var lottoInput: String
        do {
            lottoInput = getUserInputWithMessage(msg)
        } while (isValidLottoNumbers(lottoInput).not())

        return lottoInput.split(LOTTO_LIST_DELIMITER).map { it.toInt() }
    }

    fun getBonusBall(): Int {
        var lottoBonusInput: String
        do {
            lottoBonusInput = getUserInputWithMessage(LOTTO_BONUS_BALL_MESSAGE)
        } while (isValidLottoBonusBall(lottoBonusInput).not())

        return lottoBonusInput.toInt()
    }

    fun getLottoCount(): Int {
        var lottoCount: String
        do {
            lottoCount = getUserInputWithMessage(LOTTO_COUNT_MESSAGE)
        } while (isValidNatualNumber(lottoCount).not())

        return lottoCount.toInt()
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

    private fun isValidNatualNumber(lotto: String): Boolean {
        return try {
            InputValidator.checkNaturalNumber(lotto)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    private fun isValidLottoNumbers(lotto: String): Boolean {
        return try {
            InputValidator.checkValidLotto(lotto)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }
}
