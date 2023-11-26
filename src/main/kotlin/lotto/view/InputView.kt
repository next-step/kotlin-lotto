package lotto.view

import lotto.Lotto
import lotto.view.InputType.LAST_WEEK_WINNING_NUMBER

class InputView {
    fun inputNumber(inputType: InputType): Int {
        println(inputType.question)
        return readln().toInt()
    }

    fun inputLastLotto(): Lotto {
        println(LAST_WEEK_WINNING_NUMBER.question)
        val numbers = readln().split(",").map { it.trim().toInt() }.toSet()
        return Lotto(numbers)
    }
}
