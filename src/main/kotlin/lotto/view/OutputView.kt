package lotto.view

import lotto.domain.Lottos

object OutputView {

    private const val BUYING_MESSAGE_FORMAT = "%s개를 구매했습니다. 거스름돈은 %d원입니다."
    private const val LOTTO_FORMAT = "[%s]"

    fun printLottos(lottos: Lottos, change: Int) {
        val lottoCount = lottos.getLottoCount()
        println(String.format(BUYING_MESSAGE_FORMAT, lottoCount, change))
        lottos.values.forEach {
            val lottoNumbers = it.numbers.joinToString(", ")
            println(String.format(LOTTO_FORMAT, lottoNumbers))
        }
    }
}
