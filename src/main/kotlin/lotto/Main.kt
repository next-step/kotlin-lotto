package lotto

fun main(args: Array<String>) {
    println("구매금액을 입력해주세요.")
    var inputMoney = readLine()!!.toInt()

    val lottoBuyer = LottoBuyer(inputMoney)
    val lottos = lottoBuyer.buyLottoFrom(LottoStore())

    println(String.format("%s개를 구매했습니다.", lottos.size))
    lottos.forEach { lotto ->
        println(lotto.numbers)
    }

    println("지난 주 당첨 번호를 입력해주세요.")
    val lastWeekWinningNumbers = readLine()!!.split(", ").map { it.toInt() }

    lottos.forEach { lotto ->
        lotto.match(Lotto(lastWeekWinningNumbers))
    }

    println("당첨 통계")
    println("---------")
    println("3개 일치 (5000원) - ${lottos.count { it.matchCount == 3 }}개")
    println("4개 일치 (50000원) - ${lottos.count { it.matchCount == 4 }}개")
    println("5개 일치 (1500000원) - ${lottos.count { it.matchCount == 5 }}개")
    println("6개 일치 (2000000000원) - ${lottos.count { it.matchCount == 6 }}개")
    println("총 수익률은 ${lottos.size * Lotto.PRICE / inputMoney}입니다.")
}