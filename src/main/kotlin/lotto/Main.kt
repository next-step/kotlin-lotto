package lotto

import lotto.domain.LottoAnswer
import lotto.domain.LottoService
import lotto.domain.MatchCount
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val principal = InputView.getPrincipal()
    val service = LottoService.of(principal)
    OutputView.outputBuyResult(service.lottoCount, service.lotteries)

    val answer = InputView.getLottoAnswer()
    val bonusNumber = InputView.getBonusNumber()
    val lottoAnswer = LottoAnswer(answer, bonusNumber)
    val earningStrategy = mapOf(
        MatchCount.THREE to 5000,
        MatchCount.FOUR to 50000,
        MatchCount.FIVE to 1500000,
        MatchCount.FIVE_WITH_BONUS to 30000000,
        MatchCount.SIX to 2000000000
    )
    val result = service.play(lottoAnswer, earningStrategy)

    OutputView.outputLottoResult(result, earningStrategy)
}
