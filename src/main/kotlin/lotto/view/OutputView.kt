package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos

object OutputView {

    private const val COMMA = ", "
    private const val PREFIX = "["
    private const val POSTFIX = "]"

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
        return lotto.numbers.joinToString(
            separator = COMMA,
            prefix = PREFIX,
            postfix = POSTFIX
        ) { it.number.toString() }
    }
}
