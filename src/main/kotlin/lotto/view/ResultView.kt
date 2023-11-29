package lotto.view

import lotto.domain.LottoResult

class ResultView {
    fun printResult(lottoResult: LottoResult) {
        println("총 수익은 ${lottoResult.totalPrize} 입니다.")
        println("총 수익률은 ${lottoResult.profitRate} 입니다.")
    }
}
