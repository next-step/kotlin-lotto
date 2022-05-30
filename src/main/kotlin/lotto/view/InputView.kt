package lotto.view

import lotto.domain.WinningNumbers

class InputView {
    private var amount: Int = 0
    private lateinit var winningNumbers: WinningNumbers

    fun readAmount(): Int {
        println("구입금액을 입력해 주세요.")
        amount = readln().toInt()
        return amount
    }

    fun readWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(DELIMITER).map { it.trim() }.map { it.toInt() }
        println("보너스 볼을 입력해 주세요.")
        val bonus = readln().toInt()
        winningNumbers = WinningNumbers(numbers, bonus)
        return winningNumbers
    }

    fun amount(): Int = amount

    companion object {
        private const val DELIMITER = ","
    }
}
