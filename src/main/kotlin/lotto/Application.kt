package lotto

import lotto.views.Input.getBonusNumber
import lotto.views.Input.getPriceForBuying
import lotto.views.Input.getWinnerLottoNumbers
import lotto.views.Output.printBuyAmount
import lotto.views.Output.printEarningRate
import lotto.views.Output.printLottoNumbers
import lotto.views.Output.printLottoResult

fun main() {
    val inputPrice = getPriceForBuying()
    val price = BuyPrice(inputPrice)
    val boughtTicketAmount = price.getTicketCount()
    val boughtLottos = LottoNumberGenerator.generate(boughtTicketAmount)

    printBuyAmount(boughtTicketAmount)
    printLottoNumbers(boughtLottos)

    val winningLottoOrigin = getWinnerLottoNumbers()
    val bonusNumber = getBonusNumber()
    val winningLotto = WinningLottoNumbers(winningLottoOrigin, bonusNumber)

    val lottoResult = LottoResult(winningLotto, boughtLottos)
    val ranks = lottoResult.getRanks()
    val earningRate = ranks.calculateEarningRate(boughtPrice = price.price)
    printLottoResult(ranks)
    printEarningRate(earningRate)
}
