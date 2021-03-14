fun printLottoCards(lottoCards: LottoCards) {
    lottoCards.cards.forEach { println(it) }
}

fun printResult(statistic: Map<Winning, Int>, yieldRate: Double) {
    println("당첨 통계")
    println("---------")
    Winning.values().filter { it != Winning.NONE }.forEach {
        println("${it.getCondition()} - ${statistic.getOrDefault(it, 0)}개")
    }
    println("총 수익률은 ${yieldRate}입니다.")
}
