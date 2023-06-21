package lotto.view

import lotto.Lotto

object InputView {
    fun getTotalPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getPrevWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readln()
        val numbers = input.split(", ").map { it.toInt() }
        require(numbers.size == Lotto.MAX_NUMBER_COUNT) { "당첨 번호는 정확히 6개여야합니다." }
        return numbers
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        val input = readln()
        return input.toInt()
    }
}
