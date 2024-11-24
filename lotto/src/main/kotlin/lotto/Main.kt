package lotto

import lotto.domain.CorrectNumbers
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoUser
import lotto.view.InputView.inputCorrectNumbers
import lotto.view.InputView.inputPurchaseAmount
import lotto.view.ResultView.printLotteries
import lotto.view.ResultView.printLottoPurchaseAmount

fun main() {
    val lottoPurchaseAmount = LottoPurchaseAmount(inputPurchaseAmount())
    printLottoPurchaseAmount(lottoPurchaseAmount)

    val lottoUser = LottoUser(lottoPurchaseAmount)
    printLotteries(lottoUser)

    val correctNumbers = CorrectNumbers(inputCorrectNumbers())

    lottoUser.checkLotteries(correctNumbers)
}
