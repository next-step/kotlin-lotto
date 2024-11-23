package lotto

import lotto.domain.CorrectNumbers
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoUser
import lotto.view.InputView

fun main() {
    val lottoPurchaseAmount = LottoPurchaseAmount(InputView.inputPurchaseAmount())
    val lottoUser = LottoUser(lottoPurchaseAmount)

    val correctNumbers = CorrectNumbers(InputView.inputCorrectNumbers())
}
