package lotto.config

import lotto.application.LottoService
import lotto.domain.LottoType
import lotto.domain.generator.LottoNumbersGeneratorManager
import lotto.domain.generator.RandomLottoNumbersGenerator
import lotto.domain.strategy.LottoProfitCalculator
import lotto.domain.strategy.ProfitCalculator
import lotto.ui.LottoController
import lotto.ui.LottoInput
import lotto.ui.LottoOutput

object LottoConfig {

    val lottoController: LottoController by lazy {
        LottoController(
            lottoService = lottoService,
            lottoInput = lottoInput,
            lottoOutput = lottoOutput
        )
    }
    internal val lottoService: LottoService by lazy {
        LottoService(
            lottoNumbersGeneratorManager = lottoNumbersGeneratorManager,
            profitCalculator = profitCalculator
        )
    }

    internal val profitCalculator: ProfitCalculator by lazy { LottoProfitCalculator }

    private val lottoNumbersGeneratorManager: LottoNumbersGeneratorManager by lazy {
        LottoNumbersGeneratorManager().apply {
            addGenerator(LottoType.AUTO, RandomLottoNumbersGenerator)
        }
    }

    private val lottoOutput: LottoOutput by lazy { LottoOutput }
    private val lottoInput: LottoInput by lazy { LottoInput }
}
