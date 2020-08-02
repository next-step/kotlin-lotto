package view

import java.lang.IllegalArgumentException

class InputView {
    fun inputMoneyForBuyLotto(inputFunction: () -> String): Int {
        println("구입금액을 입력해 주세요.")
        val input = inputFunction()
        if (!NUMBER_REGEX.matches(input)) {
            throw IllegalArgumentException("please input number")
        }
        return input.toInt()
    }

    fun showBuyLottoCount(value: Int) {
        println("${value}개를 구매했습니다.")
    }

    fun inputLastWeekPrize(inputFunction: () -> String): List<String> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = inputFunction()
        println()
        return input.split(DELIMITER_COMMA)
    }

    companion object {
        const val DELIMITER_COMMA = ","
        val NUMBER_REGEX = Regex(pattern = "^?[0-9]\\d*(\\.\\d+)?\$")
    }
}
