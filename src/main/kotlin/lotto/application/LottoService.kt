package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoPayment
import lotto.domain.LottoResult
import lotto.domain.WinningLine

class LottoService(
    private val lineGenerator: LottoLineGenerator,
) {
    fun buy(command: BuyLottoCommand): Lotto {
        val (payment, manualLotto) = command
        val autoLotto = generateRandom(payment.numberOfLines - manualLotto.numberOfLines)
        return manualLotto.merge(autoLotto)
    }

    fun play(
        lotto: Lotto,
        winner: WinningLine,
    ): LottoResult = lotto.match(winner)

    fun generateRandom(numberOfLines: Int): Lotto = Lotto((1..numberOfLines).map { lineGenerator.generate() })
}

data class BuyLottoCommand(
    val payment: LottoPayment,
    val manualLotto: Lotto,
) {
    init {
        require(payment.numberOfLines >= manualLotto.numberOfLines) { "수동으로 구매한 로또의 수가 금액보다 많습니다." }
    }
}
