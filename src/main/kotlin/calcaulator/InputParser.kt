package calcaulator

import calcaulator.util.toIntList
import calcaulator.util.validate

private val REGEX_CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
private const val DEFAULT_DELIMITER = ",|:"

fun String?.parseInput(): Collection<Int> {
    this ?: return listOf()

    val findResult = REGEX_CUSTOM_DELIMITER.find(this)
    val delimiter = findResult.getGroupValueAt(1, default = DEFAULT_DELIMITER)
    val numberInputString = findResult.getGroupValueAt(2, default = this)

    return numberInputString.toIntList(Regex(delimiter))
        .validate { it >= 0 }
}

private fun MatchResult?.getGroupValueAt(index: Int, default: String) =
    this?.groupValues?.get(index)
        ?: default
