package stringcalculator.domain.customparser

class ParserSeparator(val string: String) {

    init {
        validate()
    }

    private fun validate() {
        require(string.isNotEmpty()) {}
        require(!Regex("(\\d)").containsMatchIn(string)) {}
    }
}
