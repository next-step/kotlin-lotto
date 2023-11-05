package org.bmsk.domain.model

data class Separator(val value: String)

data class Separators(
    private val separators: List<Separator>,
) {
    private val hashSetSeparators: HashSet<Separator> by lazy { asHashSet() }

    fun toRegex() = hashSetSeparators.joinToString("|") { Regex.escape(it.value) }.toRegex()

    fun contains(separator: Separator): Boolean {
        return hashSetSeparators.contains(separator)
    }

    operator fun plus(other: Separators): Separators {
        return Separators(other.separators + separators)
    }

    private fun asHashSet(): HashSet<Separator> = separators.toHashSet()
}
