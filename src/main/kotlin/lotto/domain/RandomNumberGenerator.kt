package lotto.domain

class RandomNumberGenerator : LottoNumberGenerator {
    override fun generate(): List<LottoNumber> {
        return RANGE.shuffled().take(LOTTO_SIZE).map(::LottoNumber)
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private val RANGE = 1..45
    }
}
