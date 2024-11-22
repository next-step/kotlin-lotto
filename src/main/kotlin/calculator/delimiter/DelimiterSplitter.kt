package calculator.delimiter

interface DelimiterSplitter {
    fun isSupport(text: String): Boolean

    fun split(text: String): List<String>
}
