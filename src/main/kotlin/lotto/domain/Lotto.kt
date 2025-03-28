package lotto.domain

class Lotto(
    lottoNumbers: List<LottoNumber>,
) {
    private val numbers = lottoNumbers.sorted()

    val rawNumbers: List<Int>
        get() = numbers.map { it.value }

    init {
        require(numbers.size == LOTTO_SIZE) { "Lotto must contain exactly 6 numbers." }
    }

    fun compareMatches(lotto: Lotto) = numbers.count { it in lotto.numbers }

    companion object {
        private const val LOTTO_SIZE = 6

        fun fromRawNumbers(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber.from(it) })
        }
    }
}
