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
        val splitPrize = prizeRecord.groupingBy { it }.eachCount()
        println(
            "${Rank.THREE_MATCH.matchCount} 개 일치 (${Rank.THREE_MATCH.reward}) - " +
                "${splitPrize[Rank.THREE_MATCH] ?: 0}개"
        )
        println(
            "${Rank.FOUR_MATCH.matchCount} 개 일치 (${Rank.FOUR_MATCH.reward}) - " +
                "${splitPrize[Rank.FOUR_MATCH] ?: 0}개"
        )
        println(
            "${Rank.FIVE_MATCH.matchCount} 개 일치 (${Rank.FIVE_MATCH.reward}) - " +
                "${splitPrize[Rank.FIVE_MATCH] ?: 0}개"
        )
        println(
            "${Rank.FIVE_BONUS_MATCH.matchCount} 개 일치, 보너스 볼 일치 (${Rank.FIVE_BONUS_MATCH.reward}) - " +
                "${splitPrize[Rank.FIVE_BONUS_MATCH] ?: 0}개"
        )
        println(
            "${Rank.ALL_MATCH.matchCount} 개 일치 (${Rank.ALL_MATCH.reward}) - " +
                "${splitPrize[Rank.ALL_MATCH] ?: 0}개"
        )
    }

    fun printIncome(Income: Double) {
        println("총 수익률은 ${Income}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
