package lotto.domain

import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.ManualLottoGenerator

enum class LottoType {
    AUTO, MANUAL;

    companion object {

        fun generatorOf(type: LottoType = AUTO, numbers: String = "") = when (type) {
            MANUAL -> ManualLottoGenerator(numbers)
            else -> AutoLottoGenerator
        }
    }
}
