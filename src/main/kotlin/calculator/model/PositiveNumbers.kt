package calculator.model

class PositiveNumbers private constructor(
    numbers: List<PositiveNumber>
) {

    val sum: Int = numbers.sumOf { it.number }

    companion object {
        fun from(numbers: List<String>): PositiveNumbers {
            val nums = numbers.map { PositiveNumber.from(it) }
            return PositiveNumbers(nums)
        }
    }
}
