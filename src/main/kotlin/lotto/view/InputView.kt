package lotto.view

import lotto.view.InputType.LAST_WEEK_WINNING_NUMBER
import lotto.view.InputType.PURCHASE_AMOUNT

class InputView {
    fun inputPrice(): Int {
        println(PURCHASE_AMOUNT.question)
        return readln().toInt()
    }

    fun inputNumbers(): List<Int> {
        println(LAST_WEEK_WINNING_NUMBER.question)
        return readln().split(",").map { it.trim().toInt() }
    }
}
