package lottogame.fixture

import lottogame.domain.generator.LottoGenerator
import lottogame.domain.lotto.GenerationType
import lottogame.domain.lotto.Lotto

fun generatorWithParameter(numbers: List<Int>): LottoGenerator {
    return LottoGenerator { Lotto.of(numbers, GenerationType.AUTO) }
}
