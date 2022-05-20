package calculator.model

object AddCalculator {

    operator fun invoke(numbers: List<Int>): Number {
        val sum = numbers.map { Number.from(it) }
            .sumOf { it.number }

        return Number.from(sum)
    }
}
