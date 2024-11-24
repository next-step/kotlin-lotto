package lotto

import lotto.domain.CorrectNumbers
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoUser
import lotto.view.InputView.inputCorrectNumbers
import lotto.view.InputView.inputPurchaseAmount
import lotto.view.ResultView.printLotteries
import lotto.view.ResultView.printLottoPurchaseAmount
import lotto.view.ResultView.printLottoResult
import lotto.view.ResultView.print수익률

fun main() {
    val lottoPurchaseAmount = LottoPurchaseAmount(inputPurchaseAmount())
    printLottoPurchaseAmount(lottoPurchaseAmount)

    val lottoUser = LottoUser(lottoPurchaseAmount)
    printLotteries(lottoUser.lotteries)

    val correctNumbers = CorrectNumbers(inputCorrectNumbers())

    lottoUser.checkLotteries(correctNumbers)
    printLottoResult(lottoUser.calculateLottoCorrectCount())
    print수익률(lottoUser.수익률)
}
