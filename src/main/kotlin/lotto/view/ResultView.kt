package lotto.view

import lotto.domain.Lotto

object ResultView {

    fun showLottoNumber(lottoNumbers: MutableList<List<Int>>) {
        lottoNumbers.forEach { println(it) }
    }

    fun showPrizeStatics(prizes: Map<Int, Lotto>, profitRate: Double) {
        println(
            "당첨 통계\n" + "---------"
        )
        prizes.forEach { (count, prize) ->
            print("$count 개 일치 (")
            print(prize.prizedAmount)
            println("원) -${prize.count} 개")
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
