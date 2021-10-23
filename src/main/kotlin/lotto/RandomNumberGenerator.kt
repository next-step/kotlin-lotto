package lotto

object RandomNumberGenerator : LottoNumberGenerator {
    override fun generateNumbers(): List<LottoNumber> {
        val numbers = initializeLottoNumbers()
        val shuffled = numbers.shuffled()
        return shuffled.subList(MINIMUM_LOTTO_SIZE, MAXIMUM_LOTTO_SIZE)
    }

    private fun initializeLottoNumbers(): List<LottoNumber> {
        return (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).map { LottoNumber.valueOf(it) }
    }

    private const val MINIMUM_LOTTO_NUMBER = 1
    private const val MAXIMUM_LOTTO_NUMBER = 45
    private const val MINIMUM_LOTTO_SIZE = 0
    private const val MAXIMUM_LOTTO_SIZE = 6
}
