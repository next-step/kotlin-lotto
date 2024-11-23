package lotto

import lotto.domain.CorrectNumbers
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoUser
import lotto.view.InputView.inputCorrectNumbers
import lotto.view.InputView.inputPurchaseAmount

fun main() {
    val lottoPurchaseAmount = LottoPurchaseAmount(inputPurchaseAmount())
    val lottoUser = LottoUser(lottoPurchaseAmount)

    val correctNumbers = CorrectNumbers(inputCorrectNumbers())

    lottoUser.checkLotteries(correctNumbers)
}
