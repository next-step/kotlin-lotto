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
        println("3개 일치 (${Rank.FIFTH.winningMoney}원) - ${ranking.rankingResult[Rank.FIFTH] ?: 0}개")
        println("4개 일치 (${Rank.FOURTH.winningMoney}원) - ${ranking.rankingResult[Rank.FOURTH] ?: 0}개")
        println("5개 일치 (${Rank.THIRD.winningMoney}원) - ${ranking.rankingResult[Rank.THIRD] ?: 0}개")
        println("5개 일치, 보너스 볼 일치 (${Rank.SECOND.winningMoney}원) - ${ranking.rankingResult[Rank.SECOND] ?: 0}개")
        println("6개 일치 (${Rank.FIRST.winningMoney}원) - ${ranking.rankingResult[Rank.FIRST] ?: 0}개")
        val result = if (LottoMachine.rateOfReturn > 1) "이익" else "손해"
        println("총 수익률은 ${String.format("%.2f", LottoMachine.rateOfReturn)}입니다.(기준이 1이기 때문에 결과적으로 ${result}라는 의미임)")
    }
}
