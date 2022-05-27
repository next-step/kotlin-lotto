package AdditionCalculator.model

private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()

class Splitter(expression: String) {
  val tokens: List<String>

  init {
    tokens = CUSTOM_DELIMITER_REGEX.find(expression)?.let {
      it.groupValues[2].split(it.groupValues[1])
    } ?: run {
      getDefaultDelimiterTokens(expression)
    }
  }

  private fun getDefaultDelimiterTokens(expression: String): List<String> {
    return expression.split(DEFAULT_DELIMITER_REGEX)
  }
}
