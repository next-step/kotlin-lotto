package calculator.domain

class Calculator {

    fun calculate(numbers: List<String>): Int {
        val numbers = convertStringToNumber(numbers)
        var sum = 0
        for (number in numbers) {
            sum += number.value
        }

        return sum
    }

    fun convertStringToNumber(numbers: List<String>): List<Number> {
        return numbers.map { stringNumber ->
            Number(stringNumber)
        }
    }
}
