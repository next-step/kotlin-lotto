package lotto.view

import lotto.domain.LottoNumber

object InputView {
    fun purchaseAmountInput(): Int {
        println("구입금액을 입력해 주세요.\n")
        val amount: Int = readln().toInt()
        require(amount > 0) {
            "구입금액은 0이하일 수 없어요."
        }
        return amount
    }

    fun winningNumberInput(): Set<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningNumber = readln()
        require(winningNumber.isNotEmpty()) {
            "당첨 번호를 입력해주세요."
        }

        val numbers = printSplitWinningNumber(winningNumber)
        require(numbers.size == 6) {
            "로또 숫자는 중복될 수 없어요."
        }

        return numbers
    }

    private fun printSplitWinningNumber(number: String): Set<LottoNumber> {
        return number
            .split(", ")
            .map {
                LottoNumber(it.toInt())
            }
            .toSet()
    }
}
