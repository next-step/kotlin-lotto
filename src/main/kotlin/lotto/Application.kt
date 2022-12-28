package lotto

import lotto.LottoEarningRate.calculateEarningRate
import lotto.LottoOffice.getRanks
import lotto.views.Input.getPriceForBuying
import lotto.views.Input.getWinnerLottoNumbers
import lotto.views.Output.printBuyAmount
import lotto.views.Output.printEarningRate
import lotto.views.Output.printLottoNumbers
import lotto.views.Output.printLottoResult

fun main() {
    val inputPrice = getPriceForBuying()
    val price = BuyPrice(inputPrice)
    val boughtTicketAmount = LottoOffice.buyTickets(price)
    val boughtLottos = LottoNumberGenerator.generate(boughtTicketAmount)

    printBuyAmount(boughtTicketAmount)
    printLottoNumbers(boughtLottos)

    val winnerNumbers = getWinnerLottoNumbers()
    val ranks = getRanks(winnerNumbers = winnerNumbers, boughtLottos = boughtLottos)
    val earningRate = calculateEarningRate(boughtPrice = price.price, ranks = ranks)
    printLottoResult(ranks)
    printEarningRate(earningRate)
}
