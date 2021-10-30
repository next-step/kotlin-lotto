package lotto.model

data class LottoNumbers(
    val num1: Int,
    val num2: Int,
    val num3: Int,
    val num4: Int,
    val num5: Int,
    val num6: Int
) {

    init {
        checkNumberRange()
        checkDuplicate()
    }

    private fun checkNumberRange() {
        val numbers = asList()
        val hasOutOfRangeNumber = numbers.any { num -> num !in MIN_NUMBER..MAX_NUMBER }

        require(!hasOutOfRangeNumber)
    }

    private fun checkDuplicate() {
        val numbers = asList()
        val distinctSize = numbers.distinct().size

        require(distinctSize == LOTTO_SIZE)
    }

    private fun asList(): List<Int> = listOf(num1, num2, num3, num4, num5, num6)

    fun match(numbers: LottoNumbers): Int {
        val numbers1 = asList()
        val numbers2 = numbers.asList()

        val array = IntArray(MAX_NUMBER + 1)
        numbers1.forEach { num -> array[num]++ }
        numbers2.forEach { num -> array[num]++ }

        return array.filter { it == 2 }.size
    }

    override fun toString(): String = "[$num1, $num2, $num3, $num4, $num5, $num6]"

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        fun random(): LottoNumbers {
            val array = IntArray(MAX_NUMBER + 1)
            var times = 0
            while (times < LOTTO_SIZE) {
                val number = (MIN_NUMBER..MAX_NUMBER).random()
                if (array[number] > 0) {
                    continue
                }
                array[number] = number
                times++
            }
            val numbers = array.filter { it > 0 }
            return LottoNumbers(
                num1 = numbers[0],
                num2 = numbers[1],
                num3 = numbers[2],
                num4 = numbers[3],
                num5 = numbers[4],
                num6 = numbers[5],
            )
        }
    }
}
