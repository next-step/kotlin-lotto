package lotto

fun main() {
    val money = InputView.inputMoney()
    val lottoMachine = LottoMachine(lottoGenerator(), money)
    ResultView.printLottos(lottoMachine.issuedLottos)
    val winningLotto = InputView.inputWinningLotto()
    val statistics = lottoMachine.issueStatistics(Lotto(*winningLotto.toIntArray()))
    ResultView.printStatistic(statistics)
}

fun lottoGenerator(): LottoGenerator {
    return LottoGenerator { Lotto.random() }
}


