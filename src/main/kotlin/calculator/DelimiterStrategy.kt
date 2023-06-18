package calculator

interface DelimiterStrategy {
    fun parse(input: String): List<Int>?
}
