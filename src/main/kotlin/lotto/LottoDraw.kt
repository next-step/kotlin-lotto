package lotto

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()
    val money = Money(purchaseMoney)
    val manualLottoCount = InputView.getManualLottoCount()
    val manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoCount)

    val userLotto = LottoIssuer.issue(money, manualLottoNumbers)

    OutputView.printLotto(manualLottoCount, userLotto)

    val numbers = InputView.getLottoNumbers()
    val number = InputView.getBonusNumber()

    val lottoNumbers = LottoNumbers.created(numbers)
    val bonusNumber = LottoNumber(number)
    val winningNumbers = WinningNumbers(lottoNumbers, bonusNumber)

    val lottoResult = LottoResultHandler.match(userLotto, winningNumbers)

    OutputView.printResult(lottoResult.results)
    OutputView.printProfitRate(lottoResult.computeProfitRate(money))
}
