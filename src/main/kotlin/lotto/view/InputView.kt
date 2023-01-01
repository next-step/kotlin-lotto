package lotto.view

import lotto.domain.LottoNumber

object InputView {
    fun purchaseAmountInput(): Int {
        println("구입금액을 입력해 주세요.")

        return readln().toInt()
    }

    fun winningNumberInput(): Set<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningNumber = readln()
        require(winningNumber.isNotEmpty()) {
            "당첨 번호를 입력해주세요."
        }

        return printSplitWinningNumber(winningNumber)
    }

    private fun printSplitWinningNumber(number: String): Set<LottoNumber> {
        return number
            .split(", ")
            .map { LottoNumber.of(number) }
            .toSet()
    }
}
