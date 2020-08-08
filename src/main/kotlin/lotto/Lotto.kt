package lotto

data class Lotto private constructor(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또의 숫자는 $LOTTO_NUMBER_SIZE 개 여야 합니다. " }
    }

    fun match(other: Lotto): Int {
        return numbers.filter { other.contains(it) }.count()
    }

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    fun contains(number: Int): Boolean = contains(LottoNumber.of(number))

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_DELIMITER = ","

        fun of(vararg numbers: Int): Lotto {
            val lottoNumbers = numbers.map { LottoNumber.of(it) }.toSet()
            return Lotto(lottoNumbers)
        }

        fun ofComma(value: String): Lotto {
            val numbers = value.split(LOTTO_DELIMITER).map { it.trim().toInt() }
            return Lotto(numbers.map { LottoNumber.of(it) }.toSet())
        }
    }
}
