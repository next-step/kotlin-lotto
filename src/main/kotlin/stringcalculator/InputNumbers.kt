package stringcalculator

data class InputNumbers(
    val values: List<InputNumber>
) {
    companion object {
        fun from(inputs: List<String>): InputNumbers {
            return InputNumbers(
                inputs.map { input -> InputNumber(input) }
            )
        }
    }
}
