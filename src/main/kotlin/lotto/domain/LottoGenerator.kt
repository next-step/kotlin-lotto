package lotto.domain

object LottoGenerator {
    private const val LOTTO_START_NUMBER = 1
    private const val LOTTO_END_NUMBER = 45
    private const val LOTTO_NUMBER_INIT = 0
    private const val LOTTO_NUMBER_COUNT = 6

    private val possibleNumbers: List<Int> =
        (LOTTO_START_NUMBER..LOTTO_END_NUMBER).map { it }

    fun generateLottoNumbers(): List<Int> =
        possibleNumbers.shuffled()
            .subList(LOTTO_NUMBER_INIT, LOTTO_NUMBER_COUNT)
}
