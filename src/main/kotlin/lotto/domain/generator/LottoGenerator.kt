package lotto.domain.generator

object LottoGenerator {

    private const val LOTTO_MIN_NUMBER = 1
    private const val LOTTO_MAX_NUMBER = 45
    private val LOTTO_RANGE = arrayOf(0, 6)

    fun generatorLotto(): List<Int> = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        .shuffled()
        .subList(LOTTO_RANGE[0], LOTTO_RANGE[1])
        .sorted()
}
