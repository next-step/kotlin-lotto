package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val numbers = splitByCustomDelimiter(text)
            ?: text.split("[,:]".toRegex())

        return numbers.sumOf { it.toInt() }
    }

    private fun splitByCustomDelimiter(text: String): List<String>? {
        return Regex("//(.*)\n(.*)").find(text)
            ?.let {
                val customDelimiter = it.groupValues[1]

                it.groupValues[2].split(customDelimiter)
            }
            ?.filter { it.isNotBlank() }
    }
}