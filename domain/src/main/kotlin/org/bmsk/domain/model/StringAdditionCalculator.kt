package org.bmsk.domain.model

class StringAdditionCalculator(stringFormula: String) {

    companion object DefaultSeparator {
        private val rest = Separator(",")
        private val colon = Separator(":")
        val defaults = Separators(listOf(rest, colon))
    }
}
