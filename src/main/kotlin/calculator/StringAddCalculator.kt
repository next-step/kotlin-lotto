package calculator

class StringAddCalculator(
    private val translator: Translator
) {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return DEFAULT_RESULT_VALUE

        return translator.run(text)
            .sumOf { it.value }
    }

    companion object {
        const val DEFAULT_RESULT_VALUE = 0
    }
}
