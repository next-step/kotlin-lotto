package lotto

import lotto.controller.LottoController
import lotto.domain.LottoStore
import lotto.domain.PurchaseLotteryTicketResult
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoController = LottoController(
        lottoInputView = LottoInputView(),
        lottoResultView = LottoResultView(),
        lottoStore = LottoStore()
    )

    when (val result = lottoController.purchaseLotteryTickets()) {
        is PurchaseLotteryTicketResult.FAIL -> {
            println("로또 구매 실패 사유 : ${result.exception.message}")
            println("입력 값을 확인하시어 다시 시도 부탁드립니다.")
        }
        is PurchaseLotteryTicketResult.SUCCESS -> {
            lottoController.printLotteryTickets(result)
            val winningLottoNumber = lottoController.readWinningLottoNumber()
            lottoController.printLottoResult(lotteryTickets = result.lotteryTickets, winningLottoNumber = winningLottoNumber)
        }
    }
}
