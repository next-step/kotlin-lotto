package service

import domain.Lotto
import domain.LottoNumber
import domain.LottoTicket
import domain.LottoWinningType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    private val lottoGame = LottoGame()

    @Test
    fun generateLottoTicketTest() {
        // given
        val purchaseLottoCount = 5

        // when
        val generatedLottos = lottoGame.generateLottoTicket(purchaseLottoCount, emptyList())

        // then
        assertThat(generatedLottos).isNotNull()
        assertThat(generatedLottos.lottoTicket).hasSize(purchaseLottoCount)
    }

    @Test
    fun generateLottoTicketWithManualLottosTest() {
        // given
        val purchaseLottoCount = 5
        val manualLottos =
            listOf(
                Lotto(setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))),
                Lotto(setOf(LottoNumber(7), LottoNumber(8), LottoNumber(9), LottoNumber(10), LottoNumber(11), LottoNumber(12))),
            )

        // when
        val generatedLottos = lottoGame.generateLottoTicket(purchaseLottoCount, manualLottos)

        // then
        assertThat(generatedLottos.lottoTicket).hasSize(purchaseLottoCount)
        assertThat(generatedLottos.lottoTicket).containsAll(manualLottos)
    }

    @Test
    fun getWinningResultTest() {
        // given
        val lottoTicket =
            LottoTicket(
                listOf(Lotto(setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))),
            )
        val winningNumbers = Lotto(setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        val purchaseLottoAmount = 1000
        val bonusBall = LottoNumber(7)

        // when
        val winningResult = lottoGame.getWinningResult(lottoTicket, winningNumbers, bonusBall, purchaseLottoAmount)

        // then
        assertThat(winningResult.result[LottoWinningType.FIRST]).isEqualTo(1)
        assertThat(winningResult.profit).isEqualTo(LottoWinningType.FIRST.priceMoney / purchaseLottoAmount.toDouble())
    }

    @Test
    fun getWinningResultWithBonusBallTest() {
        // given
        val lottoTicket =
            LottoTicket(
                listOf(Lotto(setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(7)))),
            )
        val winningNumbers = Lotto(setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        val bonusBall = LottoNumber(7)
        val purchaseLottoAmount = 1000

        // when
        val winningResult = lottoGame.getWinningResult(lottoTicket, winningNumbers, bonusBall, purchaseLottoAmount)

        // then
        assertThat(winningResult.result[LottoWinningType.SECOND]).isEqualTo(1)
    }

    @Test
    fun getWinningResultFifthTest() {
        // given
        val lottoTicket =
            LottoTicket(
                listOf(Lotto(setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(10), LottoNumber(11), LottoNumber(12)))),
            )
        val winningNumbers = Lotto(setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        val bonusBall = LottoNumber(7)
        val purchaseLottoAmount = 1000

        // when
        val winningResult = lottoGame.getWinningResult(lottoTicket, winningNumbers, bonusBall, purchaseLottoAmount)

        // then
        assertThat(winningResult.result[LottoWinningType.FIFTH]).isEqualTo(1)
    }
}
