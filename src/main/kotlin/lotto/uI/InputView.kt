package lotto.uI

import lotto.util.ErrorCode

object InputView {
    private const val ESCAPE_LINE = "\n"
    private val numberRegex = """^[0-9\s]*$""".toRegex()

    fun inputMoney(): Long {
        println(MessageCode.INPUT_MONEY.message)
        return requireNotNull(readLine()?.toLongOrNull()) { ErrorCode.MONEY_INPUT_FORMAT_EXCEPTION.errorMessage }
    }

    fun inputLastWeekLottoNumbers(): String {
        println(ESCAPE_LINE.plus(MessageCode.INPUT_LAST_WEEK_LOTTO.message))
        return requireNotNull(readLine())
    }

    fun inputBonusLottoNumber(): Int {
        println(MessageCode.INPUT_BONUS_LOTTO_NUMBER.message)

        val bonusLottoNumber = requireNotNull(readLine())

        require(bonusLottoNumber.matches(numberRegex)) {
            ErrorCode.NUMBER_EXCEPTION.errorMessage
        }
        return bonusLottoNumber.trim().toInt()
    }
}
