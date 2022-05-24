package calculator.model

class PositiveNumbers private constructor(
    private val numbers: List<PositiveNumber>
) {

    fun sum(): Int {
        return numbers.sumOf { it.number }
    }

    companion object {
        fun from(numbers: List<String>): PositiveNumbers {
            val nums = numbers.map { PositiveNumber.from(it) }
            return PositiveNumbers(nums)
        }
    }
}
