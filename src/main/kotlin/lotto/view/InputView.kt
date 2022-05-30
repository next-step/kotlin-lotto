package lotto.view

import lotto.domain.WinningNumbers

class InputView {
    private val amount: Int by lazy {
        println("구입금액을 입력해 주세요.")
        readln().toInt()
    }

    private val winningNumbers: WinningNumbers by lazy {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(",").map { it.trim() }.map { it.toInt() }
        println("지난 주 당첨 번호를 입력해 주세요.")
        val bonus = readln().toInt()
        WinningNumbers(numbers, bonus)
    }

    fun amount(): Int = amount

    fun winningNumbers(): WinningNumbers = winningNumbers
}
