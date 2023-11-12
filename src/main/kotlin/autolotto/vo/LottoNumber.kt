package autolotto.vo

@JvmInline
value class LottoNumber(val number: Int) {
    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
        private val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith(::LottoNumber)

        fun of(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.")
        }

        fun of(value: String): LottoNumber {
            return of(value.toInt())
        }

        fun of(value: List<String>): List<LottoNumber> {
            return value.map { of(it.trim().toInt()) }
        }

        fun generateLottoNumbers(): List<LottoNumber> {
            return NUMBERS.values.shuffled().take(LOTTO_NUMBER_COUNT).sortedBy { it.number }
        }
    }
}
