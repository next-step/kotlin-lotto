package lotto.ui

import lotto.domain.Money

object InputView {
    fun getPurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        val inputValue = readln()
        require(inputValue.matches("\\d+".toRegex())) { "한자리 이상 숫자만 가능합니다" }
        return Money(inputValue.toLong())
    }

    fun getLastWeekWinnerNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputValue = readln()
        return getNumbers(inputValue)
    }

    private fun getNumbers(inputValue: String) =
        inputValue.replace("\\s".toRegex(), "").split(",").map { it.toInt() }.toSet()

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val boundNumber = readln()
        return boundNumber.toInt()
    }

    fun getManualTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualNumbers(ticketCount: Int): List<Set<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(ticketCount) { getNumbers(readln()) }
    }
}
