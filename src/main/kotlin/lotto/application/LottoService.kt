package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.LottoNumber
import lotto.domain.LottoPayment
import lotto.domain.LottoResult
import lotto.domain.WinningLine

class LottoService(
    private val lineGenerator: LottoLineGenerator,
) {
    fun buy(command: BuyLottoCommand): Lotto {
        val payment = LottoPayment.from(command.payment)
        val manualLotto = Lotto.from(command.manualLotto)
        require(payment.numberOfLines >= manualLotto.numberOfLines) { "수동으로 구매한 로또의 수가 금액보다 많습니다." }

        val autoLotto = generateRandom(payment.numberOfLines - manualLotto.numberOfLines)

        return manualLotto.merge(autoLotto)
    }

    fun play(command: PlayLottoCommand): LottoResult {
        val lotto = command.lotto
        val winnerInfo = command.winner
        val payment = LottoPayment.from(command.payment)
        val winner =
            WinningLine(
                LottoLine.from(winnerInfo.line),
                LottoNumber.from(winnerInfo.bonusBall),
            )

        val matchResult = lotto.match(winner)

        return LottoResult(matchResult, payment)
    }

    fun generateRandom(numberOfLines: Int): Lotto = Lotto((1..numberOfLines).map { lineGenerator.generate() })
}
