package lotto.model

data class LottoNumbers(
    val num1: LottoNumber,
    val num2: LottoNumber,
    val num3: LottoNumber,
    val num4: LottoNumber,
    val num5: LottoNumber,
    val num6: LottoNumber
) {

    init {
        checkDuplicate()
    }

    private fun checkDuplicate() {
        val numbers = asList()
        val distinctSize = numbers.distinct().size

        require(distinctSize == LOTTO_SIZE)
    }

    private fun asList(): List<LottoNumber> = listOf(num1, num2, num3, num4, num5, num6)

    fun match(numbers: LottoNumbers): Int {
        val numbers1 = asList()
        val numbers2 = numbers.asList()

        val array = IntArray(MAX_NUMBER + 1)
        numbers1.forEach { num -> array[num.value]++ }
        numbers2.forEach { num -> array[num.value]++ }

        return array.filter { it == 2 }.size
    }

    override fun toString(): String = "[$num1, $num2, $num3, $num4, $num5, $num6]"

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        fun manual(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int): LottoNumbers = LottoNumbers(
            num1 = LottoNumber(num1),
            num2 = LottoNumber(num2),
            num3 = LottoNumber(num3),
            num4 = LottoNumber(num4),
            num5 = LottoNumber(num5),
            num6 = LottoNumber(num6),
        )

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
            return manual(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5])
        }
    }
}
