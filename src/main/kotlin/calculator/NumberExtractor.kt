package calculator

abstract class NumberExtractor(
    protected val expression: String,
) {
    abstract fun extractNumbers(): List<Int>

    companion object {
        val customPatternRegex = Regex("//(.)\n(.*)")
        val defaultDelimiters = ",|:".toRegex()
    }
}
