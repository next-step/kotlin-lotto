package lotto.util

fun String.getIntegersAfterSplit(delimiters: String): List<Int> {
    return this.split(delimiters).map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("올바르지 않은 입력입니다.") }
}
