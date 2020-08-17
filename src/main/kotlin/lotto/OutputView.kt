package lotto

object OutputView {
    fun showUserLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it)
        }
    }

    fun showResults(result: List<Rank>, rateOfReturn: Double) {
        println()
        println("당첨 통계")
        println("---------")
        Rank.values().sortedDescending().filter { it.count != 0 }.forEach {
            val value = it
            val matchCount = result.filter { it == value }.count()
            when (it) {
                Rank.SECOND ->
                    println("${value.count}개 일치, 보너스 볼 일치(${value.prize}원) - ${matchCount}개")
                else -> println("${value.count}개 일치 (${value.prize}원) - ${matchCount}개")
            }
        }
        println("총 수익률은 ${rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
