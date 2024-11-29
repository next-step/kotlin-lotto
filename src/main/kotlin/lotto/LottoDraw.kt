package lotto

fun main() {
    val purchasePrice = InputView.getPurchasePrice()

    val price = Price(purchasePrice)
    val userLotto = LottoIssuer.buy(price)

    OutputView.printLotto(userLotto)

    val winningNumbers = InputView.getWinningNumbers()

    val winningLotto = LottoNumbers.created(winningNumbers)
    val lottoResult = LottoResultHandler.match(userLotto, winningLotto)

    OutputView.printResult(lottoResult.results)
    OutputView.printProfitRate(lottoResult.computeProfitRate(price))
}
