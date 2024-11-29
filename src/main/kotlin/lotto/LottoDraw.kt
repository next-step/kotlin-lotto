package lotto

fun main() {
    val purchasePrice = InputView.getPurchasePrice()

    val price = Price(purchasePrice)
    val userLotto = LottoIssuer.buy(price)

    OutputView.printLotto(userLotto)

    val numbers = InputView.getLottoNumbers()
    val number = InputView.getBonusNumber()

    val lottoNumbers = LottoNumbers.created(numbers)
    val bonusNumber = LottoNumber.generate(number)
    val winningNumbers = WinningNumbers(lottoNumbers, bonusNumber)

    val lottoResult = LottoResultHandler.match(userLotto, winningNumbers)

    OutputView.printResult(lottoResult.results)
    OutputView.printProfitRate(lottoResult.computeProfitRate(price))
}
