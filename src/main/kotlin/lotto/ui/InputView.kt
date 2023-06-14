package lotto.ui

import lotto.domain.Lottery
import lotto.domain.Money

object InputView {
    fun getPurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        val inputValue = readln()
        require(inputValue.matches("\\d+".toRegex())) { "한자리 이상 숫자만 가능합니다" }
        return Money(inputValue.toLong())
    }

    fun getLastWeekWinnerNumbers(): Lottery {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputValue = readln()
        val numbers = inputValue.replace("\\s".toRegex(), "").split(",").map { it.toInt() }
        return Lottery(numbers)
    }
}
