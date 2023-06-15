package lotto

object LottoNumberGenerator {

    private const val LOTTO_START_NUMBER = 1
    private const val LOTTO_END_NUMBER = 45
    private const val LOTTO_NUMBER_SIZE = 6
    private val LOTTO_NUMBER_RANGE = IntRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
    fun generate(): LottoNumber {
        return LottoNumber(LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_SIZE))
    }
}
