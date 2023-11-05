package org.bmsk.domain.model

data class Separator(val value: String) {
    fun checkBelongTo(string: String): Boolean {
        return string.contains(value)
    }
}

data class Separators(val separators: List<Separator>) {

    fun checkBelongTo(string: String): Boolean {
        return separators.all { separator ->
            string.contains(separator.value)
        }
    }

    operator fun plus(separators: Separators): Separators {
        return Separators(separators.separators + this.separators)
    }
}
