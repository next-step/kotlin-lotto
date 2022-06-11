package calculator

import java.lang.RuntimeException

fun String.toNumericLong(): Long {
    val number = this.toLongOrNull()
    if (number == null || number < 0) {
        throw RuntimeException("계산기는 0보다 큰 숫자만 계산할 수 있어요. 값을 확인해주세요. numberStr: $this")
    }
    return number
}
