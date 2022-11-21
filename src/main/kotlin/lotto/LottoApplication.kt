package lotto

fun main() {
    val money = InputView.read()
    val lottoMachine = LottoMachine(money)
    lottoMachine.execute()

    val lottoSummary = lottoMachine.getSummary()
    OutputView.printSummary(lottoSummary)
}
