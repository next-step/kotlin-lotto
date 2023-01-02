package calculator

class TranslatorImpl : Translator {

    override fun run(input: String): List<Number> = getNumbers(input)

    private fun getNumbers(input: String): List<Number> {
        val strings = split(input)
        check(strings.isNotEmpty()) {
            RuntimeException("숫자를 입력해주세요.")
        }

        return strings.map { Number.of(it) }
    }

    private fun split(input: String): List<String> = input.split(delimiter)
        .filter { it.isNotBlank() }

    companion object {
        private val delimiter = "[^-\\d]".toRegex()
    }
}
