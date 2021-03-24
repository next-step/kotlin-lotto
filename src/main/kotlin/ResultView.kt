fun printLottoCards(lottoCards: LottoCards) {
    lottoCards.cards.forEach { printLottoCard(it) }
}

fun printLottoCard(lottoCard: LottoCard) {
    println("[${lottoCard.numbers.map { it.number }.joinToString(", ")}]")
}

fun printResult(statistic: Map<Winning, Int>, yieldRate: Double) {
    println("당첨 통계")
    println("---------")
    Winning.values().filter { it != Winning.NONE }.forEach {
        println("${getWinningText(it)} - ${statistic.getOrDefault(it, 0)}개")
    }
    println("총 수익률은 ${yieldRate}입니다.")
}

fun getWinningText(winning: Winning): String {
    val bonusText = if (winning == Winning.SECOND) ", 보너스 볼 일치" else ""
    return "${winning.match}개 일치$bonusText (${winning.price}원)"
}
