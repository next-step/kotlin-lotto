package lotto.domain

class Lotto(
    private val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == LOTTO_SIZE) { "Lotto must contain exactly 6 numbers." }
    }

    companion object {
        private const val LOTTO_SIZE = 6

        fun fromRawNumbers(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }
    }
}
