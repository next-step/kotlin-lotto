package lotto.application

import lotto.domain.LottoResult
import lotto.domain.LottoType
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningInfo
import lotto.domain.generator.LottoNumbersGeneratorManager
import lotto.domain.request.LottoOrderRequest
import lotto.domain.request.WinningStatisticsInfo
import lotto.domain.response.LottoCreateResponse
import lotto.domain.strategy.ProfitCalculator

class LottoService(
    private val lottoNumbersGeneratorManager: LottoNumbersGeneratorManager,
    private val profitCalculator: ProfitCalculator
) {

    fun getWinningStatistics(request: WinningStatisticsInfo): LottoResult {
        val (money, winningNumbers, bonusNumber, lottos) = request

        val inputMoney = Money(value = money)
        val winningInfo = WinningInfo.of(winningNumbersSource = winningNumbers, bonusNumberSource = bonusNumber)
        val winningStatistics = lottos.winningStatistics(winningInfo = winningInfo)
        val winningAmount = winningStatistics.map { it.key.reward times it.value.toLong() }
            .reduce(Money::plus)

        val profitRate = profitCalculator.calculate(inputMoney = inputMoney, winningAmount = winningAmount)

        return LottoResult(winningStatistics = winningStatistics, profitRate = profitRate)
    }

    fun issueLotto(requestOrderLotto: LottoOrderRequest): LottoCreateResponse {
        val autoLottos = createLottos(request = requestOrderLotto, lottoType = LottoType.AUTO)
        val manualLottos = createLottos(request = requestOrderLotto, lottoType = LottoType.MANUAL)

        val lottos = autoLottos.merge(manualLottos)

        return LottoCreateResponse(
            lottos = lottos,
            manualCount = manualLottos.size,
            autoCount = autoLottos.size
        )
    }

    private fun createLottos(request: LottoOrderRequest, lottoType: LottoType): Lottos {
        val lottoNumbersGenerator = lottoNumbersGeneratorManager.getGenerator(lottoType)

        return lottoNumbersGenerator.generate(request)
    }
}
