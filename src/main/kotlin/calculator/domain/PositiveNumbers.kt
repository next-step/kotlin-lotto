package calculator.domain

class PositiveNumbers(
    private val values: List<PositiveNumber>,
) {
    fun addAll(): PositiveNumber = PositiveNumber(values.sumOf { it.value })

    companion object {
        fun of(splitText: List<String>): PositiveNumbers =
            PositiveNumbers(splitText.map { PositiveNumber.from(text = it) })
    }
}
