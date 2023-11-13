package lotto

fun main() {
    // 1: 구입금액 입력 받기
    println("구입금액을 입력해 주세요.")
    val purchaseAmount = readln()

    // 2: 몇개 구입했는지 출력
    val lottoGame = LottoGame(purchaseAmount.toInt())

    // 3: 각 게임 결과 출력
    println(lottoGame.ticketQuantity.toString() + "개를 구매했습니다.")
    lottoGame.getAllLottoNumbers().forEach { println(it) }

    // 4: 지난 주 당첨 번호 입력 받기
    println("지난 주 당첨 번호를 입력해 주세요.")
    val lastLottoWinningNumbers = readln().split(",")
        .map { it.trim().toInt() }.sorted()
    val winningLotto = WinningLotto(lastLottoWinningNumbers)

    // 5: 당첨 통계 출력
    val lottoResultAnalytics = lottoGame.checkAllTicketResults(winningLotto)
    val winningStatistics = lottoResultAnalytics.calculateWinningStatistics()

    println("\n당첨 통계\n---------")
    winningStatistics.filter { it.key != LottoRanking.MISS }
        .forEach {
            println("${it.key.matchingCount}개 일치 (${it.key.prize}원)- ${it.value}개")
        }

    // Todo 6: 수익률 출력

}
