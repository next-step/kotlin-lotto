package calculator.delimiter

interface DelimiterSplitter {
    val priority: Int

    fun isSupport(text: String): Boolean

    fun split(text: String): List<String>
}
