package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoResult2
import lotto.domain.WinningLine

class LottoService(
    private val lineGenerator: LottoLineGenerator,
) {
    fun buy(command: BuyLottoCommand): Lotto {
        val (payment, manualLotto) = command
        val autoLotto = generateRandom(payment.numberOfLines - manualLotto.numberOfLines)
        return manualLotto.merge(autoLotto)
    }

    fun play2(
        lotto: Lotto,
        winner: WinningLine,
    ): LottoResult2 = lotto.match2(winner)

    fun generateRandom(numberOfLines: Int): Lotto = Lotto((1..numberOfLines).map { lineGenerator.generate() })
}
