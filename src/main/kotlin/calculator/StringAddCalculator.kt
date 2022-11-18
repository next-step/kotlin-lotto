package calculator

class StringAddCalculator {
    fun add(text: String?) =
        StringInput.stringToBigDecimalList(text)?.let { numbers ->
            Calculator.sum(numbers)
        }
}
