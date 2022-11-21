package stringcalculator

class Calculator {

    fun addAll(inputString: String?): Int {
        if (inputString.isNullOrBlank()) return 0

        val inputNumbers = InputNumbers.from(inputString)

        return inputNumbers.values.fold(0) { total, inputNumber ->
            total + inputNumber.value
        }
    }
}
