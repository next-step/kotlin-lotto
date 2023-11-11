package org.bmsk.domain.model

data class Separator(val value: String)

data class Separators(
    private val separators: List<Separator>,
) {
    private val _separators: Set<Separator> get() = separators.toSet()

    fun toRegex() = _separators.joinToString("|") { Regex.escape(it.value) }.toRegex()

    fun contains(separator: Separator): Boolean {
        return _separators.contains(separator)
    }

    operator fun plus(other: Separators): Separators {
        return Separators(other.separators + separators)
    }
}
