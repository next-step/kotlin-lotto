package lotto.domain

class RandomNumberGenerator : LottoNumberGenerator {
    override fun generateNumbers(): List<LottoNumber> {
        val numbers = LottoNumber.getLottoNumbers()
        val shuffled = numbers.shuffled()
        return shuffled.subList(MINIMUM_LOTTO_SIZE, MAXIMUM_LOTTO_SIZE)
    }

    companion object {
        private const val MINIMUM_LOTTO_SIZE = 0
        private const val MAXIMUM_LOTTO_SIZE = 6
    }
}
