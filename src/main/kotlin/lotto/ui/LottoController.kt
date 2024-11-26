package lotto.ui

import lotto.application.LottoService

class LottoController(
    private val lottoService: LottoService,
) {
    fun play() {
        // 금약 입력
        val payment = InputView.getPayment()

        // 수동 발급
        val numberOfManual = InputView.getNumberOfManual()

        // 로또 자동 발급
        val lotto = lottoService.generateRandom(payment.numberOfLines)
        ResultView.printLotto(lotto)

        // 당첨 번호
        val winner = InputView.getWinner()

        // 당첨 결과
        val result = lottoService.play(lotto, winner)
        ResultView.printResult(result, payment)
    }
}
