package stringcalculator

data class InputNumbers(
    val values: List<InputNumber>
) {
    fun addAll(): Int {
        return values.fold(0) { total, inputNumber ->
            total + inputNumber.value
        }
    }

    companion object {
        fun from(inputs: List<String>): InputNumbers {
            return InputNumbers(
                inputs.map { input -> InputNumber(input) }
            )
        }
    }
}
