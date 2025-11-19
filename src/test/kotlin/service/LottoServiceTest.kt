package service

import domain.Lotto
import domain.LottoTicket
import domain.LottoWinningType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {
    private val lottoService = LottoService()

    @Test
    fun purchaseAutomaticLottoTicketTest() {
        // given
        val purchaseLottoCount = 5

        // when
        val generatedLottos = lottoService.purchaseAutomaticLottoTicket(purchaseLottoCount)

        // then
        assertThat(generatedLottos).isNotNull()
        assertThat(generatedLottos.lottos).hasSize(purchaseLottoCount)
    }

    @Test
    fun getWinningResultTest() {
        // given
        val lottoTicket = LottoTicket(List(1) { Lotto(setOf(1, 2, 3, 4, 5, 6)) })
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val purchaseLottoAmount = 1000

        // when
        val winningResult = lottoService.getWinningResult(lottoTicket, winningNumbers, purchaseLottoAmount)

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
