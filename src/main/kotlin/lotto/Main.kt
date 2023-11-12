package lotto

import lotto.domain.*
import lotto.view.Input
import lotto.view.Output

fun main() {

    val lottoShop = LottoShop()
    Output.printlnAny(LottoMessage.INPUT_PURCHASE_FEE)
    val purchaseFee = Input.getLine()

    Output.printlnAny(LottoMessage.INPUT_MANUAL_PURCHASE_QUANTITY)
    val numberOfManualQuantity = Input.getLine()

    Output.printlnAny(LottoMessage.INPUT_MANUAL_LOTTO_NUMBER)
    val manualInputLines = (1..numberOfManualQuantity.toInt()).mapTo(mutableListOf()) { Input.getLine() }.toList()

    val purchase = LottoPurchase.valueOf(purchaseFee, numberOfManualQuantity, manualInputLines)
    val lotto = lottoShop.buyLotto(purchase)

    Output.lottoBuyResultPrint(lotto)
    Output.printlnAny(LottoMessage.INPUT_WINNING_NUMBERS)
    val winningNumbers = Input.getLine()
    Output.printlnAny(LottoMessage.INPUT_BONUS_NUMBER)
    val bonusNumber = Input.getLine()

    val winningNumber = LottoWinningNumber.of(winningNumbers, bonusNumber)
    val lottoResult = LottoMachine.checkLottoResult(lotto, winningNumber)

    Output.lottoRankStatisticsPrint(lottoResult)
    Output.lottoRateOfReturnPrint(lottoResult, purchase)
}
