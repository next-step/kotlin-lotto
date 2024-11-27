package lotto.ui

import lotto.application.BuyLottoCommand
import lotto.application.LottoService

class LottoController(
    private val lottoService: LottoService,
) {
    fun play() {
        // 금약 입력
        val payment = InputView.getPayment()

        // 수동 구매
        val numberOfManual = InputView.getNumberOfManual()
        val manualLotto = InputView.getManualLotto(numberOfManual)

        // 로또 발급
        val lotto = lottoService.buy(BuyLottoCommand(payment, manualLotto))
        ResultView.printLotto(lotto, numberOfManual)

        // 당첨 번호
        val winner = InputView.getWinner()

        // 당첨 결과
        val result = lottoService.play(lotto, winner)
        ResultView.printResult(result, payment)
    }

    fun play2() {
        // 금약 입력
        val payment = InputView.getPayment()

        // 수동 구매
        val numberOfManual = InputView.getNumberOfManual()
        val manualLotto = InputView.getManualLotto(numberOfManual)

        // 로또 발급
        val lotto = lottoService.buy(BuyLottoCommand(payment, manualLotto))
        ResultView.printLotto(lotto, numberOfManual)

        // 당첨 번호
        val winner = InputView.getWinner()

        // 당첨 결과
        val result = lottoService.play2(lotto, winner)
        ResultView.printResult2(result, payment)
    }
}
