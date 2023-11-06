package lotto

fun tokenizeWinningNumbers(input: String): List<Int> {
    return input
        .split(",")
        .filterNot { it.isBlank() }
        .map { it.trim().toInt() }
}
