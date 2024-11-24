package calculator.model.input

object InputValidator {
    fun validateNumbers(numbers: List<Int>) {
        numbers.forEach { number ->
            if (number < 0) throw IllegalArgumentException("음수는 계산할 수 없습니다.")
        }
    }

    fun validateDelimiters(
        nonNumeric: List<String>,
        delimiters: Array<String>,
    ) {
        nonNumeric.forEach { delimiter ->
            if (delimiter !in delimiters) throw IllegalArgumentException("지원하지 않는 구분자가 포함되어 있습니다.")
        }
    }
}
