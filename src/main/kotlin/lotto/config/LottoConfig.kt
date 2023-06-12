package lotto.config

import lotto.application.LottoService
import lotto.domain.LottoType
import lotto.domain.generator.LottoNumbersGenerator
import lotto.domain.generator.RandomLottoNumbersGenerator
import lotto.domain.strategy.LottoProfitCalculator
import lotto.domain.strategy.ProfitCalculator

object LottoConfig {

    internal val lottoService: LottoService by lazy {
        LottoService(
            lottoNumbersGenerators = lottoNumberGenerator,
            profitCalculator = profitCalculator
        )
    }

    internal val profitCalculator: ProfitCalculator by lazy { LottoProfitCalculator }
    private val lottoNumberGenerator: Map<LottoType, LottoNumbersGenerator> by lazy {
        mapOf(LottoType.AUTO to RandomLottoNumbersGenerator)
    }
}
