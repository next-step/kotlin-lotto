package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.generator.LottoGenerator

fun generatorWithParameter(numbers: List<Int>): LottoGenerator {
    return LottoGenerator { Lotto.from(numbers) }
}
