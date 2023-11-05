package org.bmsk.domain.model

class StringAdditionCalculator(private val stringFormula: String) {

    fun calculate(): Int {
        val customSeparators = extractCustomSeparators(stringFormula)
        return separateBy(customSeparators).sum()
    }

    fun separateBy(customSeparators: Separators = Separators(emptyList())): List<Int> {
        val realStringFormula = if (stringFormula.contains("\n")) {
            stringFormula.split("\n")[1]
        } else {
            stringFormula
        }
        realStringFormula.ifBlank { return emptyList() }
        val allSeparators = defaults.separators + customSeparators.separators
        val pattern = allSeparators.joinToString("|") { Regex.escape(it.value) }.toRegex()
        return realStringFormula.split(pattern).map { it.trim().toInt() }
    }

    private fun extractCustomSeparators(stringFormula: String): Separators {
        val result = Regex("//(.)\n(.*)").find(stringFormula)
        return if (result != null) {
            Separators(listOf(Separator(result.groupValues[1])))
        } else {
            Separators(emptyList())
        }
    }

    companion object DefaultSeparator {
        private val rest = Separator(",")
        private val colon = Separator(":")
        val defaults = Separators(listOf(rest, colon))
    }
}
