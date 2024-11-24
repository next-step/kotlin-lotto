package lotto

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val price = Price(purchasePrice)

    val userLotto = LottoIssuer.buy(price)

    // TODO: 14개를 구매했습니다
    // TODO: [8, 21, ...]
    //    userLotto.forEach { numbers ->
    //        println(numbers.numbers.joinToString { it.value.toString() })
    //    }

    val winningNumbers = InputView.getWinningNumbers()
    val winningLotto = LottoNumbers.created(winningNumbers)

    val result = LottoResultHandler.match(userLotto, winningLotto)

    OutputView.printResult(result)
}