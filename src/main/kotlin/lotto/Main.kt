package lotto

import lotto.domain.Customer
import lotto.domain.LottoMachine
import lotto.domain.LottoMessage
import lotto.domain.LottoShop
import lotto.domain.LottoWinningNumber
import lotto.view.Input
import lotto.view.Output

fun main() {

    val lottoShop = LottoShop()
    val lottoMachine = LottoMachine()
    Output.printlnAny(LottoMessage.INPUT_PURCHASE_FEE)

    val purchaseFee = Input.getLine()
    val customer = Customer.valueOf(purchaseFee)
    val lotto = lottoShop.buyLotto(customer.money)

    Output.lottoBuyResultPrint(lotto)
    Output.printlnAny(LottoMessage.INPUT_WINNING_NUMBERS)
    val winningNumbers = Input.getLine()
    Output.printlnAny(LottoMessage.INPUT_BONUS_NUMBER)
    val bonusNumber = Input.getLine()

    val winningNumber = LottoWinningNumber.of(winningNumbers, bonusNumber)
    val lottoResult = lottoMachine.checkLottoResult(lotto, winningNumber)

    Output.lottoRankStatisticsPrint(lottoResult)
    Output.lottoRateOfReturnPrint(lottoResult, customer)
}
