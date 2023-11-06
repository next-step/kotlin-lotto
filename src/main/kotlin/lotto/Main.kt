package lotto

import lotto.domain.Customer
import lotto.domain.LottoMachine
import lotto.domain.LottoMessage
import lotto.domain.LottoShop
import lotto.view.Input
import lotto.view.Output

fun main() {

    val lottoShop = LottoShop()
    val lottoMachine = LottoMachine()
    Output.printlnAny(LottoMessage.INPUT_PURCHASE_FEE)

    val purchaseFee = Input.getLine()
    val customer = Customer.of(purchaseFee)
    val lotto = lottoShop.buyLotto(customer)

    Output.lottoBuyResultPrint(lotto)
    Output.printlnAny(LottoMessage.INPUT_WINNING_NUMBERS)
    val winningNumbers = Input.getLine()
    val lottoResult = lottoMachine.checkLottoResult(lotto, winningNumbers)

    Output.lottoRankStatisticsPrint(lottoResult)
    Output.lottoRateOfReturnPrint(lottoResult, customer)
}
