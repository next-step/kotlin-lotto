package lotto.view

import lotto.error.ErrorMessage.*

object InputView {

    fun inputMoney(): Int {
        try {
            return readln().toInt()
        } catch (e: NullPointerException) {
            throw IllegalArgumentException(EMPTY_INPUT_MESSAGE.message)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(EXPECT_NUMBER_MESSAGE.message)
        }
    }
}
