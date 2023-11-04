package lotto

import lotto.domain.Customer
import lotto.domain.LottoMessage
import lotto.domain.LottoShop
import lotto.view.View

fun main() {

    val purchaseFee = View.messagePrintAndGetLine(LottoMessage.INPUT_PURCHASE_FEE)
    val customer = Customer(purchaseFee)
    val lotto = LottoShop().buyLotto(customer)

    View.lottoBuyResultPrint(lotto)
}
