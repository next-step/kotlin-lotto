package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.LottoType
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningInfo
import lotto.domain.WinningStatisticsInfo
import lotto.domain.generator.LottoNumbersGeneratorManager
import lotto.domain.strategy.ProfitCalculator

class LottoService(
    private val lottoNumbersGeneratorManager: LottoNumbersGeneratorManager,
    private val profitCalculator: ProfitCalculator
) {

    fun getWinningStatistics(request: WinningStatisticsInfo): LottoResult {
        val inputMoney = Money(value = request.money)
        val winningStatistics =
            request.lottos.winningStatistics(winningInfo = WinningInfo.of(winningNumbersSource = request.winningNumbers, bonusNumberSource = request.bonusNumber))
        val winningAmount = winningStatistics.map { it.key.reward times it.value }
            .reduce(Money::plus)

        val profitRate = profitCalculator.calculate(inputMoney = inputMoney, winningAmount = winningAmount)

        return LottoResult(winningStatistics = winningStatistics, profitRate = profitRate)
    }

    fun issueAutoLotto(requestMoney: Int): Lottos {
        val money = Money(requestMoney)

        require(money >= Lotto.PRICE) {
            "로또를 구매할 수 있는 금액이 아닙니다. Input: $requestMoney"
        }

        return createLottos(inputMoney = money, lottoType = LottoType.AUTO)
    }

    private fun createLottos(inputMoney: Money, lottoType: LottoType): Lottos {
        val lottoNumbersGenerator = lottoNumbersGeneratorManager.getGenerator(lottoType)
            ?: throw IllegalStateException("Could not find lottery generator mapped to ${LottoType.AUTO}.")

        return (0 until getAvailableQuantity(inputMoney)).map { lottoNumbersGenerator.generate() }
            .map(::Lotto)
            .toList()
            .let(::Lottos)
    }

    private fun getAvailableQuantity(inputMoney: Money): Int = (inputMoney / Lotto.PRICE).value
}
