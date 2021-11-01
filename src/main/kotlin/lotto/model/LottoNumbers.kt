package lotto.model

@JvmInline
value class LottoNumbers private constructor(
    private val numbers: List<LottoNumber>
) {

    init {
        checkDuplicate()
    }

    private fun checkDuplicate() {
        val distinctSize = numbers.distinct().size
        require(distinctSize == LOTTO_SIZE)
    }

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    fun match(target: LottoNumbers): Int {
        val array = IntArray(MAX_NUMBER + 1)
        numbers.forEach { num -> array[num.value]++ }
        target.numbers.forEach { num -> array[num.value]++ }

        return array.filter { it == 2 }.size
    }

    override fun toString(): String = numbers.toString()

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        fun manual(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int): LottoNumbers =
            listOf(num1, num2, num3, num4, num5, num6)
                .map { LottoNumber(it) }
                .let(::LottoNumbers)

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
            return LottoNumbers(numbers.map { LottoNumber(it) })
        }
    }
}
