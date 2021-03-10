package calculator.domain

private val CUSTOM_SEPARATOR = "//"

class ReadStrategySelector {
    fun selectStringReadStrategy(string: String): StringReadStrategy {
        return when {
            string.startsWith(CUSTOM_SEPARATOR) -> {
                CustomReadStrategy()
            }
            else -> {
                StandardReadStrategy()
            }
        }
    }
}
