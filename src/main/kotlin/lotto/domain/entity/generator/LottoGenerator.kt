package lotto.domain.entity.generator

import lotto.filter.LottoFilter

object LottoGenerator {

    private const val LOTTO_MIN_NUMBER = 1
    private const val LOTTO_MAX_NUMBER = 45
    private val LOTTO_RANGE = arrayOf(0, 6)

    fun generatorUserLotto(): List<Int> = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        .shuffled()
        .subList(LOTTO_RANGE[0], LOTTO_RANGE[1])
        .sorted()

    fun generatorWinningLotto(winningLottoNumber: String): List<Int> = winningLottoNumber
        .split(",")
        .map { LottoFilter.verify(it.trim().toInt()) }
        .distinct()
        .sorted()
}
