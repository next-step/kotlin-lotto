package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoBuyingPrice
import lotto.domain.LottoNumber

object InputView {

    private const val DELIMITER = ","
    private const val BUYING_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."

    fun readBuyingPrice(): LottoBuyingPrice {
        println(BUYING_PRICE_MESSAGE)
        val userInput = readlnOrNull()
        validateIsNullOrBlank(userInput)
        validateNumeric(userInput!!.trim())
        return LottoBuyingPrice(userInput.toInt())
    }

    fun readWinningLotto(): Lotto {
        println(System.lineSeparator() + WINNING_NUMBERS_MESSAGE)
        val userInput = readlnOrNull()
        validateIsNullOrBlank(userInput)
        return splitWinningNumbers(userInput!!).map {
            validateNumeric(it.trim())
            it.trim().toInt()
        }.let {
            Lotto.from(it.map { number -> LottoNumber(number) })
        }
    }

    private fun validateIsNullOrBlank(userInput: String?) {
        require(userInput.isNullOrBlank().not()) {
            "입력값이 존재하지 않습니다."
        }
    }

    private fun validateNumeric(userInput: String) {
        require(userInput.toIntOrNull() != null) {
            "입력값이 숫자가 아닙니다."
        }
    }

    private fun splitWinningNumbers(userInput: String): List<String> {
        return userInput.split(DELIMITER).toList()
    }
}
