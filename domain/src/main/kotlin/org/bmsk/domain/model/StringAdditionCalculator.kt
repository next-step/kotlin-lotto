package org.bmsk.domain.model

class StringAdditionCalculator(private val stringFormula: String) {

    fun calculate(): Int {
        return separateBy().sum()
    }

    fun separateBy(additionalSeparators: Separators = Separators(emptyList())): List<Int> {
        stringFormula.ifBlank { return emptyList() }

        val allSeparators = defaults + additionalSeparators

        return allSeparators.separators.fold(stringFormula) { formula, separator ->
            formula.replace(separator.value, rest.value)
        }.split(rest.value).map { it.trim().toInt() }
    }

//    private fun findCustomSeparators(): Separators {
//
//    }

    companion object DefaultSeparator {
        private val rest = Separator(",")
        private val colon = Separator(":")
        val defaults = Separators(listOf(rest, colon))
    }
}
