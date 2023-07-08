package lotto.fixture

import lotto.Lotto
import lotto.generator.LottoGenerator

fun generatorWithParameter(numbers: List<Int>): LottoGenerator {
    return LottoGenerator { Lotto.from(numbers) }
}
