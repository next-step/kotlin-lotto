package stringcalculator.domain

import java.lang.NumberFormatException

fun String.toIntOrThrowsRuntimeException(): Int {
    try {
        return this.toInt()
    } catch (e: NumberFormatException) {
        throw RuntimeException("숫자 형태가 아닌 문자입니다. 입력된 문자($this)")
    }
}
