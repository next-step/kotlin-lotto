package lotto

import lotto.domain.LottoAnswer
import lotto.domain.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val principal = InputView.getPrincipal()
    val service = LottoService.of(principal)
    OutputView.outputBuyResult(service.lottoCount, service.lotteries)

    val answer = InputView.getLottoAnswer()
    val lottoAnswer = LottoAnswer(answer)
    val earningStrategy = mapOf(3 to 5000, 4 to 50000, 5 to 1500000, 6 to 2000000000)
    val result = service.play(lottoAnswer, earningStrategy)

    OutputView.outputLottoResult(result, earningStrategy)
}