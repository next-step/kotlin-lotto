package lotto.view

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

object InputView {

    fun inputPayment(): Int {
        return try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력해주세요.")
        }
    }
}
