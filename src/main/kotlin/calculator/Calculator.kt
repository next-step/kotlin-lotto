package calculator

class Calculator {

    fun calculate(numbers: List<String>): Int {
        var sum = 0
        for (number in numbers) {
            sum += number.toInt()
        }

        return sum
    }
}
