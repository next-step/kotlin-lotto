package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val (pattern, target) = Regex("//(.)\n(.*)")
            .find(text)
            ?.groupValues
            ?.let { groupValues ->
                val customDelimiter = groupValues[1]
                val target = groupValues[2]
                "[,:$customDelimiter]" to target
            } ?: ("[,:]" to text)
        return target.split(Regex(pattern))
            .sumOf { it.toInt() }
    }
}
