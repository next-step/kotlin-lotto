package lotto.view

import lotto.domain.Lotto

object ResultView {

    fun showLottoNumber(lottoNumbers: MutableList<List<Number>>) {
        lottoNumbers.forEach { println(it) }
    }

    fun showPrizeStatics(prizes: List<Lotto>, profitRate: Double) {
        println(
            "당첨 통계\n" + "---------"
        )
        prizes.forEach { it ->
            print("${it.prize.countOfMatch} 개 일치 (")
            print(it.prize.prizeMoney)
            println("원) -${it.count} 개")
        }
        print("총 수익률은 $profitRate 입니다.")
        if (profitRate < 1) {
            print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }

    fun showLottoCount(count: Int) {
        println("$count 개를 구매했습니다.")
    }
}
