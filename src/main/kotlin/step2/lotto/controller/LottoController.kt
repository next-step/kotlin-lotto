package step2.lotto.controller

import step2.lotto.domain.PlayInfo
import step2.lotto.io.InputView
import step2.lotto.io.ResultView.printResult
import step2.lotto.service.LottoService
import step2.lotto.service.RandomLottoGenerator

class LottoController {
    private val lottoService: LottoService = LottoService(RandomLottoGenerator())

    fun playLotto() {
        val buyAmount = InputView.inputBuyAmount()
        val winningNumber = InputView.inputWinningNumber()
        val playInfo = PlayInfo.of(buyAmount, winningNumber)

        val playResult = lottoService.play(playInfo)
        printResult(playInfo, playResult)
    }
}
