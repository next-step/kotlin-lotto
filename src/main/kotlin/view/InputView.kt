package view

import model.Lotto
import model.LottoNumber
import model.Money

class InputView {
    fun getMoney(input: () -> String?): Money {
        println("구매금액을 입력해 주세요.")
        return Money(input())
    }

    fun getPrizeLotto(input: () -> String?): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputString = input()
        checkNotNull(inputString)
        require(PRIZE_REGEX.matches(inputString)) { "not accepted prize regex" }
        val inputPrizeNumbers = removeWhiteSpace(inputString)

        return Lotto(makeLottoNumber(inputPrizeNumbers))
    }

    private fun makeLottoNumber(inputPrizeNumbers: String) =
        inputPrizeNumbers.split(DELIMITER).map { LottoNumber.from(it.toInt()) }

    private fun removeWhiteSpace(inputString: String): String {
        return if (inputString.contains(" ")) {
            inputString.replace(" ", "")
        } else {
            inputString
        }
    }

    companion object {
        val PRIZE_REGEX = Regex(pattern = "^[0-9,\\s]+\$")
        const val DELIMITER = ","
    }
}
