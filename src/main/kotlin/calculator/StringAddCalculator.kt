package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (text.contains('-')) {
            throw RuntimeException()
        }

        val splits = splitByCustomDelimiter(text)
            ?: text.split("[,:]".toRegex())

        val numbers = splits.map { it.toInt() }

        return numbers.sum()
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
