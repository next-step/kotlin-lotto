fun printLottoCards(lottoCards: LottoCards) {
    lottoCards.cards.forEach { println(it) }
}

fun printResult(statistic: Map<Winning, Int>, yieldRate: Double) {
    println("당첨 통계")
    println("---------")
    Winning.values().forEach {
        println("${it.match}개 일치 (${it.price}원)- ${statistic.getOrDefault(it, 0)}개")
    }
    println("총 수익률은 ${yieldRate}입니다.")
}
