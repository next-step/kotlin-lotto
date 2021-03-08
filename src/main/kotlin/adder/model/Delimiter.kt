package adder.model

class Delimiter(val input: String) {
    fun hasCustom(): Boolean {
        return REGEX.matches(input)
    }

    companion object {
        private const val REGEX_FOR_DELIMITER = """//(.)\\n(.*)"""
        private val REGEX = REGEX_FOR_DELIMITER.toRegex()
    }
}