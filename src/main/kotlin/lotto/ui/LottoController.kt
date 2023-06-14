package lotto.ui

import lotto.application.LottoService
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.WinningStatisticsInfo

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
        val bonusNumber = lottoInput.requestBonusNumber()

        val lottoResult: LottoResult = lottoService.getWinningStatistics(
            request = WinningStatisticsInfo(
                money = money,
                winningNumbers = inputWinningNumbers,
                bonusNumber = bonusNumber,
                lottos = lottos
            )
        )

        lottoOutput.printLottoResult(lottoResult = lottoResult)
    }
}
