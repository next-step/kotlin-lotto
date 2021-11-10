package addcalculator.domain

object SplitStringDelimiter {

    private val DEFAULT_SPLIT_PATTERN = "[,:]".toRegex()
    private val CUSTOM_DELIMITER_PATTERN = "(.)\n(.*)".toRegex()
    private const val STRING_LOCATION = 2
    private const val CUSTOM_DELIMITER_PATTERN_LOCATION = 0

    fun splitValue(inputValue: String): List<String> {

        fun find() = CUSTOM_DELIMITER_PATTERN.find(inputValue)
        return find()?.let {
            it.groupValues[STRING_LOCATION].split(it.value[CUSTOM_DELIMITER_PATTERN_LOCATION])
        } ?: inputValue.split(DEFAULT_SPLIT_PATTERN)
    }
}
