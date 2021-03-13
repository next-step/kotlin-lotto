fun printLottoCards(lottoCards: LottoCards) {
    lottoCards.cards.forEach { println(it) }
}

fun printResult(statistic: List<Winning>, yieldRate: Double) {
    println("당첨 통계")
    println("---------")
    Winning.values().filter { it != Winning.NONE }.forEach {
        val count = statistic.count { it2 -> it == it2 }
        println("${it.match}개 일치 (${it.price}원)- ${count}개")
    }
    println("총 수익률은 ${yieldRate}입니다.")
}
