package lotto

import lotto.domain.DefaultLottoGenerator
import lotto.service.LottoService
import lotto.view.input.BuyInputView
import lotto.view.input.WinningLottoInputView
import lotto.view.result.BuyResultView
import lotto.view.result.LottoResultView
import lotto.view.result.LottosView

fun main() {
    val lottoService = LottoService(DefaultLottoGenerator)

    val payAmount = BuyInputView.print()
    val lottosDto = lottoService.createLottos(payAmount)

    BuyResultView.print(lottosDto.lottos.size)
    LottosView.print(lottosDto)

    val winningLottoDto = WinningLottoInputView.print()
    val resultsDto = lottoService.getResults(lottosDto, winningLottoDto, 0)

    LottoResultView.print(resultsDto)
}
