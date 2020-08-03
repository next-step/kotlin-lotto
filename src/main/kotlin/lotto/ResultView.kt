package lotto

object ResultView {

    fun showLottoNumber(lottoNumber: List<Int>) {
        println(lottoNumber)
    }

    fun showPrizeStatics(prizes: HashMap<Int, Int>, profitRate: Double) {
        println(
            "당첨 통계\n" + "---------"
        )
        prizes.forEach { (count, _prize) ->
            print("$count 개 일치 (")
            print(PRIZE_AMOUNT[count])
            println("원) -$_prize 개")
        }
        println("총 수익률은 $profitRate 입니다.")
    }
}
