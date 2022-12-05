package lotto.uI

import lotto.domain.LottoCustomGenerator
import lotto.domain.LottoList
import lotto.util.ErrorCode

object InputView {
    private const val ESCAPE_LINE = "\n"
    private val numberRegex = """^[0-9\s]*$""".toRegex()
    private const val INIT_LOTTO_COUNT = 1

    fun inputMoney(): Long {
        println(MessageCode.INPUT_MONEY.message)
        return requireNotNull(readLine()?.toLongOrNull()) { ErrorCode.MONEY_INPUT_FORMAT_EXCEPTION.errorMessage }
    }

    fun inputManualLottoCount(): Long {
        println(MessageCode.INPUT_MANUAL_LOTTO_COUNT.message)
        val lottoNumber = requireNotNull(readLine())

        require(lottoNumber.matches(numberRegex)) {
            ErrorCode.NUMBER_EXCEPTION.errorMessage
        }
        return lottoNumber.trim().toLong()
    }

    private fun inputManualLotto(): String =
        requireNotNull(readLine())

    fun inputManualLottoList(manualLottoCount: Long): LottoList {
        println(MessageCode.INPUT_MANUAL_LOTTO_NUMBERS.message)
        val lottoList = (INIT_LOTTO_COUNT..manualLottoCount).map {
            LottoCustomGenerator.generateLotto(inputManualLotto())
        }
        return LottoList(lottoList)
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
