package lotto

object RandomLottoNumberGenerator {
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
    private const val LOTTO_NUMBER_COUNT = 6

    private val lottoNumbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()

    fun generate(): List<Int> {
        return lottoNumbers.shuffled().take(LOTTO_NUMBER_COUNT)
    }
}