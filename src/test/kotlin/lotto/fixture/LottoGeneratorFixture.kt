package lotto.fixture

import lotto.domain.GenerateType
import lotto.domain.TypeLotto
import lotto.domain.generator.LottoGenerator

fun generatorWithParameter(numbers: List<Int>): LottoGenerator {
    return LottoGenerator { TypeLotto.of(numbers, GenerateType.AUTO) }
}
