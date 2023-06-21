package stringaddcalculator.domain

class NumbersGenerator(private val input: String) {

    init {
        require(input.isNotBlank()) { "빈 문자열은 입력할 수 없습니다." }
    }

    fun generate(): List<Number> {
        return byDefaultDelimiters()
    }

    private fun byDefaultDelimiters() = input.split(DEFAULT_DELIMITER_REGEX)
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { Number.of(it) }

    companion object {
        private const val DEFAULT_DELIMITER_REGEX = "[,:]"
    }
}
