package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos

object OutputView {

    private const val COMMA = ", "
    private const val PREFIX = "["
    private const val POSTFIX = "]"
    private const val LOTTO_RESULT = "당첨 통계"
    private const val DASH = "---------"

    fun showLottos(lottos: Lottos) {
        val output = buildString {
            append(lottos.lottos.count()).append("개를 구매했습니다.")
            append(System.lineSeparator())
            lottos.lottos.forEach {
                append(printLottoNumbers(it))
                append(System.lineSeparator())
            }
        }
        println(output)
    }

    fun printLottoNumbers(lotto: Lotto): String {
        return lotto.sortedNumbers.joinToString(
            separator = COMMA,
            prefix = PREFIX,
            postfix = POSTFIX
        ) { it.number.toString() }
    }

    fun print(lottos: Lottos) {
        println(LOTTO_RESULT)
        println()
    }
}
