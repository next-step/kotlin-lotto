package lotto

fun main() {
    val purchasePrice = InputView.getPurchasePrice()                // VIEW(input)

    val price = Price(purchasePrice)
    val userLotto = LottoIssuer.buy(price)

    OutputView.printLotto(userLotto)                                // VIEW(output)

    val winningNumbers = InputView.getWinningNumbers()

    val winningLotto = LottoNumbers.created(winningNumbers)
    val lottoResult = LottoResultHandler.match(userLotto, winningLotto)

    OutputView.printResult(lottoResult.results)                      // VIEW(output)
    OutputView.printProfitRate(lottoResult.computeProfitRate(price)) // VIEW(output)
}