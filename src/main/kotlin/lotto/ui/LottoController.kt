package lotto.ui

import lotto.application.LottoService
import lotto.domain.LottoResult
import lotto.domain.request.WinningStatisticsInfo

class LottoController(
    private val lottoService: LottoService,
    private val lottoInput: LottoInput,
    private val lottoOutput: LottoOutput
) {

    fun issueAndPrintWinningStatistics() {
        val lottoOrderRequest = lottoInput.requestOrderLotto()
        val lottoCreateResponse = lottoService.issueLotto(lottoOrderRequest)

        lottoOutput.printLotto(lottoCreateResponse)

        val winningInfoRequest = lottoInput.requestWinningInfo()

        val lottoResult: LottoResult = lottoService.getWinningStatistics(
            request = WinningStatisticsInfo(
                money = lottoOrderRequest.money,
                winningNumbers = winningInfoRequest.values,
                bonusNumber = winningInfoRequest.bonusNumber,
                lottos = lottoCreateResponse.lottos
            )
        )

        lottoOutput.printLottoResult(lottoResult = lottoResult)
    }
}
