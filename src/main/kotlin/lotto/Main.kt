package lotto

fun main() {
    val money = InputView.inputMoney()
    val lottos = LottoMachine(RandomLottoNumberGenerator()).generateLotto(money)
    OutputView.printLottos(lottos)
    val pastWinningNumbers = InputView.inputPastWinningNumbers()
    val lottoRule = LottoRule(pastWinningNumbers)
    val lottoResult = lottoRule.calculateResult(lottos)
    OutputView.printResult(lottoResult)
}
