package lotto.view

import lotto.domain.Lotto

object ResultView {
    private const val TEXT_RESULT_PURCHASE_NUMBER = "%d개를 구매했습니다."
    private const val LOTTO_NUMBER_PREFIX = "["
    private const val LOTTO_NUMBER_POSTFIX = "]"
    private const val LOTTO_NUMBER_SEPARATOR = ", "

    fun printLotto(lottos: List<Lotto>) {
        println(TEXT_RESULT_PURCHASE_NUMBER.format(lottos.size))
        lottos.forEach { lotto ->
            println(
                lotto.lottoNumbers.joinToString(
                    separator = LOTTO_NUMBER_SEPARATOR,
                    prefix = LOTTO_NUMBER_PREFIX,
                    postfix = LOTTO_NUMBER_POSTFIX,
                ),
            )
        }
        println()
    }
}
