package calculator.model

class Numbers private constructor(
    private val numbers: List<Number>
) {

    fun sum(): Int {
        return numbers.sumOf { it.number }
    }

    companion object {
        fun from(numbers: List<String>): Numbers {
            val nums = numbers.map { Number.from(it) }
            return Numbers(nums)
        }
    }
}
