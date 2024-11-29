package lotto

data class LottoNumbers(val numbers: List<LottoNumber>) {
    fun countMatch(winningLotto: LottoNumbers): Int {
        return this.numbers.count { it in winningLotto.numbers }
    }

    fun matchBonus(bonusNumber: LottoNumber): Boolean {
        return bonusNumber in numbers
    }

    override fun toString(): String {
        return numbers
            .sortedBy { it.value }
            .joinToString { it.value.toString() }
    }

    companion object {
        private const val LOTTO_COUNT = 6

        fun created(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber(it) })
        }

        fun generate(range: IntRange): LottoNumbers {
            return LottoNumbers(mutableSetOf<LottoNumber>().apply {
                while (size < LOTTO_COUNT) {
                    add(LottoNumber.generate(range.random()))
                }
            }.toList())
        }
    }
}
