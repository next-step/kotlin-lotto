package lotto.view

import lotto.domain.LottoItems
import lotto.domain.value.LottoNumber

object ResultView {
    private const val BUY_COUNT_SURFIX = "개를 구매했습니다."
    fun printBuyCount(buyCount: Int) {
        println("${buyCount}$BUY_COUNT_SURFIX")
    }

    fun printResult(
        lottos: List<Any>,
        lottoItems: LottoItems,
        winningNumbers: List<LottoNumber>
    ) {
        println(lottos.joinToString(""))
        println("당첨 통계")
        println("---------")
        val result = lottoItems.getWinLottos(winningNumbers)
        println(result.joinToString(""))
    }
}
