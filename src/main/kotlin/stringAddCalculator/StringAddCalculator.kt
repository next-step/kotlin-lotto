package stringaddcalculator

private val isAllPositive = { list: List<Int> ->
    if (list.all { it < 0 }) throw RuntimeException("음수는 허용하지 않습니다.")
    list
}
class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        return getNumberList(text).sum()
    }

    private fun getCustomSeparator(text: String) = GET_SEPARATOR.toRegex().find(text)?.groupValues?.get(1)
    private fun getNumberList(text: String): List<Int> {
        val customSeparator = getCustomSeparator(text)
        return when {
            text.toIntOrNull() != null -> listOf(text)
            customSeparator != null -> text.split("\\n")[1].split(customSeparator)
            text.contains(',') || text.contains(':') -> text.split(',', ':')
            else -> emptyList()
        }.map { it.toInt() }.let(isAllPositive)
    }

    companion object {
        private const val GET_SEPARATOR = "\\/\\/(.*?)\\\\n"
    }
}
