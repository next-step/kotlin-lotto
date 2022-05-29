package calculator.domain

class PositiveNumbers(
    private val values: List<PositiveNumber>,
) {
    fun sum(): PositiveNumber = PositiveNumber(values.sumOf { it.value })

    companion object {
        fun of(texts: List<String>): PositiveNumbers =
            PositiveNumbers(texts.map { PositiveNumber.from(text = it) })
    }
}
