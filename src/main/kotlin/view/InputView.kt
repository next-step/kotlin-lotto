package view

import kotlin.properties.Delegates

class InputView {
    var money by Delegates.notNull<Int>()
    var prize by Delegates.notNull<List<String>>()

    fun inputMoneyForBuyLotto(inputFunction: () -> String) {
        println("구입금액을 입력해 주세요.")
        val input = inputFunction()
        if (!NUMBER_REGEX.matches(input)) {
            throw IllegalArgumentException("please input number")
        }
        money = input.toInt()
    }

    fun showBuyLottoCount(value: Int) {
        println("${value}개를 구매했습니다.")
    }

    fun inputLastWeekPrize(inputFunction: () -> String) {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = inputFunction()
        if (!PRIZE_REGEX.matches(input)) {
            throw IllegalArgumentException("please input valid regex")
        }
        println()
        prize = input.replace(WHITESPACE_REGEX, "").split(DELIMITER_COMMA)
    }

    companion object {
        const val DELIMITER_COMMA = ","
        val NUMBER_REGEX = Regex(pattern = "^?[0-9]\\d*(\\.\\d+)?\$")
        val PRIZE_REGEX = Regex(pattern = "^[0-9,\\s]+\$")
        val WHITESPACE_REGEX = Regex(pattern = "\\s")
    }
}
