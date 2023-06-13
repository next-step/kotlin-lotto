package lotto.ui

import lotto.application.LottoService
import lotto.domain.LottoCreateRequest
import lotto.domain.LottoResult
import lotto.domain.Lottos

class LottoController(
    private val lottoService: LottoService,
    private val lottoInput: LottoInput,
    private val lottoOutput: LottoOutput
) {

    fun issueAndPrintWinningStatistics() {
        val money: Int = lottoInput.requestMoney()
        val lottos: Lottos = lottoService.issueAutoLotto(money)

        lottoOutput.printLotto(lottos)

        val inputWinningNumbers: List<String> = lottoInput.requestWinningNumbers()

        val lottoResult: LottoResult = lottoService.getWinningStatistics(
            request = LottoCreateRequest(
                money = money,
                winningNumbers = inputWinningNumbers,
                lottos = lottos
            )
        )

        lottoOutput.printLottoResult(lottoResult = lottoResult)
    }
}
