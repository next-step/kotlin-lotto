package calculator

object StringCalculator {
    fun calculate(input: String): Int {
        val nums = splitNum(input)
        return nums.sum()
    }

    private fun splitNum(input: String): List<Int> {
        return input.split(',').map { it.toInt() }
    }

}
