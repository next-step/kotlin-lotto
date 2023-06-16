package lotto.view

import lotto.domain.*

object ResultView {

    fun showBuyResult(buyedLottoes: LottoNumbers) {
        println("${buyedLottoes.lottoNumbers.size}개를 구매했습니다.")
        buyedLottoes.lottoNumbers.forEach {
            println(it.lottoNumber)
        }
    }

    fun showGameResult(ranking: Ranking) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${Rank.THREE.winningMoney}원)- ${ranking.threeCorrect}개")
        println("3개 일치 (${Rank.FOUR.winningMoney}원)- ${ranking.fourCorrect}개")
        println("3개 일치 (${Rank.FIVE.winningMoney}원)- ${ranking.fiveCorrect}개")
        println("3개 일치 (${Rank.SIX.winningMoney}원)- ${ranking.sixCorrect}개")
        val result = if (LottoMachine.rateOfReturn > 1) "이익" else "손해"
        println("총 수익률은 ${String.format("%.2f", LottoMachine.rateOfReturn)}입니다.(기준이 1이기 때문에 결과적으로 ${result}라는 의미임)")
    }
}
