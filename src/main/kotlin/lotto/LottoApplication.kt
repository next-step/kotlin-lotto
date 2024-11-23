package lotto

import lotto.controller.LottoController
import lotto.infrastructure.RandomLottoBallMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoController = LottoController(InputView(), OutputView(), RandomLottoBallMachine())
    lottoController.run {
        announcePurchasedLotto()
        announceGameResult()
    }
}
