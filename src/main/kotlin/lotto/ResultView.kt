package lotto

object ResultView {
    fun printBuyedLottoTicket(purchased: List<Lotto>) {
        println("${purchased.size}개를 구매했습니다.")
        purchased.forEach { (println(it.numbers)) }
        print(" ")
    }

    fun printWinnerStatistics(prizeRecord: List<Rank>) {
        println("당첨 통계")
        println("----------")
        val splitPrize = prizeRecord.groupBy { it.matchCount }
        println(
            "${Rank.THREEMATCH.matchCount} 개 일치 (${Rank.THREEMATCH.reward}) - " +
                "${splitPrize[Rank.THREEMATCH.matchCount]?.size ?: 0}개"
        )
        println(
            "${Rank.FOURMATCH.matchCount} 개 일치 (${Rank.FOURMATCH.reward}) - " +
                "${splitPrize[Rank.FOURMATCH.matchCount]?.size ?: 0}개"
        )
        println(
            "${Rank.FIVEMATCH.matchCount} 개 일치 (${Rank.FIVEMATCH.reward}) - " +
                "${splitPrize[Rank.FIVEMATCH.matchCount]?.size ?: 0}개"
        )
        println(
            "${Rank.ALLMATCH.matchCount} 개 일치 (${Rank.ALLMATCH.reward}) - " +
                "${splitPrize[Rank.ALLMATCH.matchCount]?.size ?: 0}개"
        )
    }
}
