package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val lottoPay = 1000
    val inputView = InputView()
    val outputView = OutputView()
    val lottoPrizeInfo = LottoPrizeInfo(
        listOf(
            LottoPrizeData(3, 5000),
            LottoPrizeData(4, 50000),
            LottoPrizeData(5, 1500000),
            LottoPrizeData(6, 2000000000)
        )
    )

    val lottoMachine = LottoMachine(lottoPay, lottoPrizeInfo)
    val lottoDataList = lottoMachine.issue(inputView.inputPayment())
    outputView.showPurchases(lottoDataList)

    val winnerLottoData: WinnerLottoData = lottoMachine.getWinnerLottoData(inputView.inputWinnerNumbers(), lottoDataList)
    outputView.showResult(winnerLottoData)
}
