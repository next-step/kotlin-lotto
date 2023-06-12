package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoCreateRequest
import lotto.domain.LottoResult
import lotto.domain.LottoType
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningNumbers
import lotto.domain.generator.LottoNumbersGenerator
import lotto.domain.strategy.ProfitCalculator

class LottoService(
    private val lottoNumbersGenerators: Map<LottoType, LottoNumbersGenerator>,
    private val profitCalculator: ProfitCalculator
) {

    fun getWinningStatistics(request: LottoCreateRequest, winningNumbers: WinningNumbers): LottoResult {
        val inputMoney = Money(value = request.money).takeIf { it >= Lotto.PRICE }
            ?: throw IllegalArgumentException("로또 금액은 ${Lotto.PRICE.value} 이상 필요합니다. Input: ${request.money}")
        val lottos = createLottos(inputMoney)

        val winningStatistics = lottos.winningStatistics(winningNumbers = winningNumbers)
        val winningAmount = winningStatistics.map { it.key.reward times it.value }
            .reduce(Money::plus)

        val profitRate = profitCalculator.calculate(inputMoney = inputMoney, winningAmount = winningAmount)

        return LottoResult(winningStatistics = winningStatistics, profitRate = profitRate)
    }

    private fun createLottos(inputMoney: Money): Lottos {
        val lottoNumbersGenerator = lottoNumbersGenerators[LottoType.AUTO]
            ?: throw IllegalStateException("Could not find lottery generator mapped to ${LottoType.AUTO}.")

        return (0 until getAvailableQuantity(inputMoney)).map { lottoNumbersGenerator.generate() }
            .map(::Lotto)
            .toList()
            .let(::Lottos)
    }

    private fun getAvailableQuantity(inputMoney: Money): Int = (inputMoney / Lotto.PRICE).value
}
