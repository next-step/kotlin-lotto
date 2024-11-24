package lotto

class LottoNumbers(private val numbers: List<LottoNumber>) {

    fun countMatch(winningLotto: LottoNumbers): Int {
        return this.numbers.count { it in winningLotto.numbers }
    }

    companion object {
        private const val LOTTO_COUNT = 6

        fun generate(): LottoNumbers {
            val numbers = generateNumbers()
            require(numbers.size == LOTTO_COUNT) { "로또 숫자가 충분하지 않습니다." }
            return LottoNumbers(numbers.toList())
        }

        private fun generateNumbers(): Set<LottoNumber> {
            val numbers = mutableSetOf<LottoNumber>()
            while (numbers.size < LOTTO_COUNT) {
                numbers.add(LottoNumber.generate())
            }
            return numbers
        }

        fun created(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber(it) })
        }
    }
}
