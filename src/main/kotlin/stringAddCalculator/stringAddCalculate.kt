package stringAddCalculator

fun stringAddCalculate(text: String?): Int {
    if (text.isNullOrBlank()) {
        return 0
    }
    val strings: List<String> = split(text)
    val numbers: List<Int> = toNumbers(strings)
    return numbers.sum()
}
