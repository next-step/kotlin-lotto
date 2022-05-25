package lotto.util

fun String.toIntThrow() =
    try {
        this.toInt()
    } catch (e: Exception) {
        throw RuntimeException("구분자외에는 숫자만 입력해야합니다.")
    }
