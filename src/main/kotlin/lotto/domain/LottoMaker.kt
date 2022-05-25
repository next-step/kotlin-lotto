package lotto.domain

object LottoMaker {
    const val LOTTO_NUMBER_COUNT = 6
    const val START_LOTTO_NUMBER = 1
    const val END_LOTTO_NUMBER = 45

    private val lottoNumberRange = (START_LOTTO_NUMBER..END_LOTTO_NUMBER)

    fun make(): List<Int> = lottoNumberRange.shuffled().take(LOTTO_NUMBER_COUNT)
}
