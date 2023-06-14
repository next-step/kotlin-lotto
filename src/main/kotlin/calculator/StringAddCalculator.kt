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

        val numbers = target.split(Regex(pattern))
            .map { it.toIntOrNull() ?: throw RuntimeException("$it is not integer") }
        numbers.forEach { number ->
            if (number < 0) {
                throw RuntimeException("$number is negative")
            }
        }

        return numbers.sum()
    }
}
