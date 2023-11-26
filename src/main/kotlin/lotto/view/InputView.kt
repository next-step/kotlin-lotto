package lotto.view

import lotto.Lotto
import lotto.view.InputType.LAST_WEEK_WINNING_NUMBER
import lotto.view.InputType.PURCHASE_AMOUNT

class InputView {
    fun inputPrice(): Int {
        println(PURCHASE_AMOUNT.question)
        return readln().toInt()
    }

    fun inputNumbers(): Lotto {
        println(LAST_WEEK_WINNING_NUMBER.question)
        val numbers = readln().split(",").map { it.trim().toInt() }.toSet()
        return Lotto(numbers)
    }
}
