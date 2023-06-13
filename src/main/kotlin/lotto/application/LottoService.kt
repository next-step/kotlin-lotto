package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoCreateRequest
import lotto.domain.LottoResult
import lotto.domain.LottoType
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningNumbers
import lotto.domain.generator.LottoNumbersGeneratorManager
import lotto.domain.strategy.ProfitCalculator

class LottoService(
    private val lottoNumbersGeneratorManager: LottoNumbersGeneratorManager,
    private val profitCalculator: ProfitCalculator
) {

    fun getWinningStatistics(request: LottoCreateRequest): LottoResult {
        val inputMoney = Money(value = request.money)
        val winningStatistics =
            request.lottos.winningStatistics(winningNumbers = WinningNumbers.from(strings = request.winningNumbers))
        val winningAmount = winningStatistics.map { it.key.reward times it.value }
            .reduce(Money::plus)

        val profitRate = profitCalculator.calculate(inputMoney = inputMoney, winningAmount = winningAmount)

        return LottoResult(winningStatistics = winningStatistics, profitRate = profitRate)
    }

    fun issueAutoLotto(requestMoney: Int): Lottos = Money(requestMoney).takeIf { it >= Lotto.PRICE }
        ?.let { createLottos(inputMoney = it, lottoType = LottoType.AUTO) }
        ?: throw IllegalArgumentException("로또를 구매할 수 있는 금액이 아닙니다. Input: $requestMoney")

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
