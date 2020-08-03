package lotto

object ResultView {

    fun showLottoNumber(lottoNumber: List<Int>) {
        println(lottoNumber)
    }

    fun showPrizeStatics(prizes: HashMap<Int, Lotto>, profitRate: Double) {
        println(
            "당첨 통계\n" + "---------"
        )
        prizes.forEach { (count, _prize) ->
            print("$count 개 일치 (")
            print(_prize.prizedAmount)
            println("원) -${_prize.count} 개")
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
