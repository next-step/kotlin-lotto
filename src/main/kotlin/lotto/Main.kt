package lotto

import lotto.domain.Customer
import lotto.domain.LottoMachine
import lotto.domain.LottoMessage
import lotto.domain.LottoShop
import lotto.view.View

fun main() {

    val lottoShop = LottoShop()
    val lottoMachine = LottoMachine()
    val purchaseFee = View.messagePrintAndGetLine(LottoMessage.INPUT_PURCHASE_FEE)
    val customer = Customer.of(purchaseFee)
    val lotto = lottoShop.buyLotto(customer)

    View.lottoBuyResultPrint(lotto)

    val winningNumbers = View.messagePrintAndGetLine(LottoMessage.INPUT_WINNING_NUMBERS)
    val lottoResult = lottoMachine.checkLottoResult(lotto, winningNumbers)

    View.lottoRankStatisticsPrint(lottoResult)
    View.lottoRateOfReturnPrint(lottoResult, customer)
}
