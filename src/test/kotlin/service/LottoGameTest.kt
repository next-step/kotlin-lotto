package service

import domain.Lotto
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
        val generatedLottos = lottoGame.generateLottoTicket(purchaseLottoCount)

        // then
        assertThat(generatedLottos).isNotNull()
        assertThat(generatedLottos.lottoTicket).hasSize(purchaseLottoCount)
    }

    @Test
    fun getWinningResultTest() {
        // given
        val lottoTicket = LottoTicket(listOf(Lotto(setOf(1, 2, 3, 4, 5, 6))))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val purchaseLottoAmount = 1000

        // when
        val winningResult = lottoGame.getWinningResult(lottoTicket, winningNumbers, purchaseLottoAmount)

        // then
        assertThat(winningResult).isNotNull()
        assertThat(winningResult.result[LottoWinningType.FIRST]).isEqualTo(1)
        assertThat(winningResult.result[LottoWinningType.SECOND]).isNull()
        assertThat(winningResult.result[LottoWinningType.THIRD]).isNull()
        assertThat(winningResult.result[LottoWinningType.FOURTH]).isNull()
        assertThat(winningResult.result[LottoWinningType.NONE]).isNull()
        assertThat(winningResult.profit).isEqualTo(LottoWinningType.FIRST.priceMoney / purchaseLottoAmount.toDouble())
    }
}
