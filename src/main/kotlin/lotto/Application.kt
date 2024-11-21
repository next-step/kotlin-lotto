package lotto

fun main() {
    val userAmount = InputView.readMessage("구입금액을 입력해 주세요.")
    val amount = Amount(userAmount)

    val boughtLotto = Lottos.fromCount(amount, RandomLottoNumbersGenerator())
    ResultView.print("${boughtLotto.size}개를 구매했습니다.")
    ResultView.printBoughtLotto(boughtLotto)

    val lastWeekNumbers = InputView.readCsvToInt("지난 주 당첨 번호를 입력해 주세요.")
    val lastWeekLotto = Lotto.from(lastWeekNumbers)

    val ranks = boughtLotto.ranks(lastWeekLotto)
    ResultView.printStatistics(ranks, amount)
}
