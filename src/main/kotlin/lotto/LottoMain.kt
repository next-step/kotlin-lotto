package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val lottoPrizeInfo = LottoPrizeInfo(
        1000,
        listOf(
            LottoPrizeData(3, 5000),
            LottoPrizeData(4, 50000),
            LottoPrizeData(5, 1500000),
            LottoPrizeData(6, 2000000000)
        )
    )

    val lottoMachine = LottoMachine(lottoPrizeInfo.lottoPay, lottoPrizeInfo)
    val lottoDataList = lottoMachine.issue(InputView.inputPayment())
    OutputView.showPurchases(lottoDataList)

    val winnerLottoData: WinnerLottoData = lottoMachine.getWinnerLottoData(InputView.inputWinnerNumbers(), lottoDataList)
    OutputView.showResult(winnerLottoData)
}
