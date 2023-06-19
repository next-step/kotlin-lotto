package lotto.view

import lotto.domain.LottoEnum

object ResultView {
    fun printPurchaseResult(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.count()}개를 구매했습니다.")
        lottoNumbers.forEach { lotto ->
            println(lotto)
        }
    }

    fun printWinningResultComment() {
        println("당첨 통계")
        println("---------")
    }

    fun printWinningResultStatistics(mapResult: Map<Int, Int>) {
        mapResult.forEach{
            println("${it.key}개 일치 (${LottoEnum.of(it.key)}원)- ${it.value}개")
        }
    }

    fun printRateOfReturn(rate: Float) {
        println("총 수익률은 ${rate}입니다.")
    }
}
