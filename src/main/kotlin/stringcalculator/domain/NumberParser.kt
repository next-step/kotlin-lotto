package stringcalculator.domain

class NumberParser {
    fun parse(
        numbersPart: String,
        delimitersRegex: Regex,
    ): List<Number> {
        return numbersPart.split(delimitersRegex)
            .filter { it.isNotBlank() }.map { Number.from(it) }
    }
}
