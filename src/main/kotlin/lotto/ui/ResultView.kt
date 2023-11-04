package lotto.ui

import lotto.domain.Lotto

object ResultView {

    private const val LOTTO_NUMBERS_DELIMITER = ", "
    private const val LOTTO_NUMBERS_PREFIX = "["
    private const val LOTTO_NUMBERS_POSTFIX = "]"

    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            val lottoNumbers = lotto.numbers
            println(lottoNumbers.map { it.value }.joinToString(LOTTO_NUMBERS_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_POSTFIX))
        }
        println()
    }
}
