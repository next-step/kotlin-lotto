package lotto.view

import lotto.domain.LottoStorage

object OutputView {

    private const val BUYING_MESSAGE_FORMAT = "%s개를 구매했습니다. 거스름돈은 %d원입니다."
    private const val LOTTO_FORMAT = "[%s]"

    fun printLottos(lottoStorage: LottoStorage, change: Int) {
        val lottoCount = lottoStorage.getLottoCount()
        println(String.format(BUYING_MESSAGE_FORMAT, lottoCount, change))
        lottoStorage.lottos.forEach {
            val lottoNumbers = it.numbers.joinToString(", ")
            println(String.format(LOTTO_FORMAT, lottoNumbers))
        }
    }
}
