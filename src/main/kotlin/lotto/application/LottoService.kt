package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoLineGenerator

class LottoService(
    private val lottoGenerator: LottoLineGenerator,
) {
    fun generateRandom(numberOfLines: Int): Lotto {
        val lines = (1..numberOfLines).map { lottoGenerator.generate() }
        return Lotto.from(lines)
    }
}
