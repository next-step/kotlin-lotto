package calulator.delimiterParser

interface DelimiterStrategy {
    fun support(text: String): Boolean
    fun parse(text: String): List<Int>
}
