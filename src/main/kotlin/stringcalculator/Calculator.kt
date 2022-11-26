package stringcalculator

class Calculator {

    fun addAll(inputString: String?): Int {
        if (inputString.isNullOrBlank()) return 0
        val separated = DefaultSeparator.separate(inputString)

        val inputNumbers = InputNumbers.from(separated)

        return inputNumbers.values.fold(0) { total, inputNumber ->
            total + inputNumber.value
        }
    }
}
