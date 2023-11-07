package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatResult
import lotto.domain.Rank

object ResultView {
    fun showPurchasedLotto(lottoList: List<Lotto>) {
        println("${lottoList.count()}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        println()
    }

    fun showLottoStatResult(lottoStatResult: LottoStatResult) {
        val returnRate = lottoStatResult.getReturnRate()

        println("\n당첨 통계\n---------")
        Rank.values().filter { it.countOfMatch > 0 }.forEach { it ->
            println("${it.countOfMatch}개 일치${if (it.isMatchBonus) ", 보너스 볼 일치" else " "}(${it.winningMoney}원)- ${lottoStatResult.getCount(it)}개")
        }
        println("총 수익률은 ${returnRate}입니다.${if (returnRate < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}")
    }
}
