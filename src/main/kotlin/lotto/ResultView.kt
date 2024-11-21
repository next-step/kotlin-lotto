package lotto

object ResultView {
    fun print(message: List<String>) {
        println(message)
    }

    fun printStatistics(
        ranks: Ranks,
        amount: Amount,
    ) {
        println("당첨 통계")
        println("---------")
        Rank.prizeRanks.forEach {
            val count = ranks.count(it)
            println("${it.matchCount}개 일치 (${it.prize.value}원) - ${count}개")
        }
        println("총 수익률은 ${ranks.rate(amount)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    fun print(message: String) {
        println(message)
    }
}
