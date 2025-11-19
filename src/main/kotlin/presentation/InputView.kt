package presentation

import domain.Lotto

class InputView {
    companion object {
        fun inputPurchaseAmount(): Int {
            println("구입금액을 입력해 주세요.")
            return readln().toInt()
        }

        fun inputWinningNumbers(): Set<Int> {
            println("지난 주 당첨번호를 입력해 주세요.")
            val inputWinningNumbers = readln().split(",").map { it.trim().toInt() }
            return Lotto(inputWinningNumbers.toSet()).numbers
        }
    }
}
