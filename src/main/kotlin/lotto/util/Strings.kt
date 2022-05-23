package lotto.util

fun String.isInt() = try {
    this.toInt()
    true
} catch (e: NumberFormatException) {
    false
}
