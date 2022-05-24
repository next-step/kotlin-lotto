package calculator.domain

class AddNumbers(
    private val values: List<AddNumber>,
) {
    fun addAll(): AddNumber = AddNumber(values.sumOf { it.value })

    companion object {
        fun of(splitText: List<String>): AddNumbers =
            AddNumbers(splitText.map { AddNumber.from(text = it) })
    }
}
