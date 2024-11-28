package calculator

class Numbers private constructor(private val values: List<Int>) {
    companion object {
        fun from(numbers: List<Int>): Numbers {
            val negativeNumbers = numbers.filter { it < 0 }
            if (negativeNumbers.isNotEmpty()) {
                throw IllegalArgumentException("음수는 허용되지 않습니다.")
            }
            return Numbers(numbers)
        }
    }

    fun sum(): Int = values.sum()
}
