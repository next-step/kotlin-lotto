package calculator

class StringAddCalculator {
    private val delimeters = mutableListOf(",", ":")

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val sections = text.split(SECTION_DELEMETER)
        val numberString: String = if (sections.size > 1) {
            delimeters.add(sections.first().split(CUSTOM_DELEMETER_HEADER).last())
            sections.last()
        } else {
            sections.first()
        }

        val numbers = numberString
            .split(*delimeters.toTypedArray())
            .map { it.toInt() }

        numbers.forEach { require(it > 0) }

        return numbers.reduce { a, b -> a + b }
    }

    companion object {
        const val SECTION_DELEMETER = "\n"
        const val CUSTOM_DELEMETER_HEADER = "//"
    }
}