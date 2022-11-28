package lotto.domain

object LottoNumbersGenerator {
    private val LOTTO_NUMBER_RANGE = 1..45
    private const val LOTTO_NUMBER_SIZE = 6

    fun generate(): List<Int> {
        return LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_SIZE)
    }
}