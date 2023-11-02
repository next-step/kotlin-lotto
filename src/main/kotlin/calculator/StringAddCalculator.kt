package calculator

private const val SPLITER = ","

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val numbers = text.split(SPLITER)
        return numbers.sumOf { it.toInt() }
    }
}