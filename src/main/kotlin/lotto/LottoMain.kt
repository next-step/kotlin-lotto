package lotto

import lotto.controller.LottoController
import lotto.domain.LottoStore
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoController = LottoController(
        lottoInputView = LottoInputView(),
        lottoResultView = LottoResultView(),
        lottoStore = LottoStore()
    )

    val purchaseLotteryTickets = lottoController.purchaseLotteryTickets()
    lottoController.printLotteryTickets(purchaseLotteryTickets)

    val winningLottoNumber = lottoController.readWinningLottoNumber()

    lottoController.printLottoResult(lotteryTickets = purchaseLotteryTickets.lotteryTickets, winningLottoNumber = winningLottoNumber)
}
