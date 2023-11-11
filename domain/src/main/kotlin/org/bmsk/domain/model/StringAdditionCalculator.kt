package org.bmsk.domain.model

class StringAdditionCalculator(private val stringFormula: String) {

    private val realStringFormula: String = extractRealStringFormula()
    private val customSeparators: Separators = extractCustomSeparators()
    private val allSeparators: Separators = defaults + customSeparators

    init {
        StringAdditionValidator().validateFormat(realStringFormula, allSeparators)
    }

    fun calculate(): Int {
        return separate().sum()
    }

    internal fun separate(): List<Int> {
        realStringFormula.ifBlank { return emptyList() }
        val pattern = allSeparators.toRegex()
        return realStringFormula.split(pattern).map { it.trim().toInt() }
    }

    private fun extractCustomSeparators(): Separators {
        val result = Regex("//(.)\n(.*)").find(stringFormula)
        return if (result != null) {
            Separators(listOf(Separator(result.groupValues[1])))
        } else {
            Separators(emptyList())
        }
    }

    private fun extractRealStringFormula(): String {
        return if (stringFormula.contains("\n")) {
            stringFormula.split("\n")[1]
        } else {
            stringFormula
        }
    }

    companion object DefaultSeparator {
        private val rest = Separator(",")
        private val colon = Separator(":")
        val defaults = Separators(listOf(rest, colon))
    }
}
