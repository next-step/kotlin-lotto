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
            LottoPrizeData(5, 30000000, true),
            LottoPrizeData(6, 2000000000)
        )
    )

    val inputPayment = InputView.inputPayment()
    val lottoMachine = LottoMachine(lottoPrizeInfo.lottoPay, lottoPrizeInfo)
    val lottoDataList = lottoMachine.issue(inputPayment)
    OutputView.showPurchases(lottoDataList)

    val winnerNumberData = WinnerNumberData(InputView.inputWinnerNumbers(), InputView.inputBonusNumber())
    val winnerLottoData: WinnerLottoData = lottoMachine.getWinnerLottoData(winnerNumberData, lottoDataList, inputPayment)
    OutputView.showResult(winnerLottoData)
}
