package lotto

data class Lotto(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또의 숫자는 $LOTTO_NUMBER_SIZE 개 여야 합니다. " }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(LottoNumber.of(number))
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6

        fun of(vararg numbers: Int): Lotto {
            val lottoNumbers = numbers.map { LottoNumber.of(it) }.toSet()
            return Lotto(lottoNumbers)
        }

        fun ofComma(value: String): Lotto {
            val numbers = value.split(",").map { it.trim().toInt() }
            return Lotto(numbers.map { LottoNumber.of(it) }.toSet())
        }
    }
}
