package calculator

interface DelimiterStrategy {
    fun supports(text: String): Boolean

    fun parse(text: String): List<Int>
}
