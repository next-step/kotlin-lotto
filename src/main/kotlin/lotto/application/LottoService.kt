package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.LottoResult

class LottoService(
    private val lineGenerator: LottoLineGenerator,
) {
    fun play(
        lotto: Lotto,
        winner: LottoLine,
    ): LottoResult = lotto.match(winner)

    fun generateRandom(numberOfLines: Int): Lotto =
        Lotto.from(
            (1..numberOfLines).map { lineGenerator.generate() },
        )
}
