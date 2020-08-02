package lotto.view

import lotto.domain.LottoItems
import lotto.domain.value.LottoNumber

object ResultView {
    fun printBuyCount(buyCount: Int) {
        println("${buyCount}개를 구매했습니다.")
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
