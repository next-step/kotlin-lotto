package lotto

fun main() {
    val userAmount = InputView("구입금액을 입력해 주세요.").read()
    val amount = Amount(userAmount)

    val boughtLotto = Lottos.fromCount(amount, RandomLottoNumbersGenerator())

    ResultView.print("${boughtLotto.size}개를 구매했습니다.")
    ResultView.print(boughtLotto.concat(","))

    val values = InputView("지난 주 당첨 번호를 입력해 주세요.").readCsvToInt()
    val lastWeekLotto = Lotto.from(values)

    println("당첨 통계")
    println("---------")
    val ranks = boughtLotto.ranks(lastWeekLotto)

    Rank.prizeRanks.forEach {
        val count = ranks.count(it)
        println("${it.matchCount}개 일치 (${it.prize.value}원) - ${count}개")
    }

    println("총 수익률은 ${ranks.rate(amount)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
}
