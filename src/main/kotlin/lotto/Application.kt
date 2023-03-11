package lotto

import lotto.views.Input.getBonusNumber
import lotto.views.Input.getManualLottoAmount
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

    val manualLottoAmount = getManualLottoAmount()
    val lottoAmount = LottoAmount(totalAmount = boughtTicketAmount, manualAmount = manualLottoAmount)

    val autoLottoNumbers = LottoAutoGenerator().generate(lottoAmount.autoAmount)
    val manualLottoNumbers = LottoManualGenerator().generate(lottoAmount.manualAmount)

    printBuyAmount(manualAmount = lottoAmount.manualAmount, autoAmount = lottoAmount.autoAmount)
    printLottoNumbers(autoLottoNumbers)

    val winningLottoOrigin = getWinnerLottoNumbers()
    val bonusNumber = getBonusNumber()
    val winningLotto = WinningLottoNumbers(winningLottoOrigin, bonusNumber)

    val lottoResult = LottoResult(winningLotto, autoLottoNumbers + manualLottoNumbers)
    val ranks = lottoResult.getRanks()
    val earningRate = ranks.calculateEarningRate(boughtPrice = price.price)

    printLottoResult(ranks)
    printEarningRate(earningRate)
}
