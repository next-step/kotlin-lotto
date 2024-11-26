package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.WinningLine

class LottoService(
    private val lineGenerator: LottoLineGenerator,
) {
    fun play(
        lotto: Lotto,
        winner: WinningLine,
    ): LottoResult = lotto.match(winner)

    fun generateRandom(numberOfLines: Int): Lotto =
        Lotto.from(
            (1..numberOfLines).map { lineGenerator.generate() },
        )
}
