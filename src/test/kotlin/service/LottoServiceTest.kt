package service

import domain.lotto.Lotto
import domain.lotto.LottoNumber
import domain.lotto.LottoTicket
import domain.purchase.LOTTO_PRICE
import domain.purchase.LottoPurchaseInfo
import domain.winning.LottoWinningType
import domain.winning.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {
    private val lottoService = LottoService(ProfitCalculator(), AutomaticLottoGenerateService())

    @Test
    fun purchaseLottoTicketTest() {
        // given
        val purchaseLottoCount = 5
        val purchaseInfo = LottoPurchaseInfo(purchaseLottoCount * LOTTO_PRICE, emptyList())

        // when
        val generatedLottos = lottoService.purchaseLottoTicket(purchaseInfo)

        // then
        assertThat(generatedLottos).isNotNull()
        assertThat(generatedLottos.lottos).hasSize(purchaseLottoCount)
    }

    @Test
    fun getWinningResultTest() {
        // given
        val lottoTicket =
            LottoTicket(
                listOf(
                    Lotto.fromNumbers(1, 2, 3, 4, 5, 6),
                    Lotto.fromNumbers(1, 2, 3, 4, 5, 7),
                ),
            )
        val winningLottoNumbers = Lotto.fromNumbers(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(7)
        val purchaseLottoAmount = 2000

        // when
        val winningResult = lottoService.getWinningResult(lottoTicket, WinningLotto(winningLottoNumbers, bonusNumber), purchaseLottoAmount)

        // then
        assertThat(winningResult).isNotNull()
        assertThat(winningResult.result[LottoWinningType.FIRST]).isEqualTo(1)
        assertThat(winningResult.result[LottoWinningType.SECOND_WITH_BONUS]).isEqualTo(1)
        assertThat(winningResult.result[LottoWinningType.SECOND]).isNull()
        assertThat(winningResult.result[LottoWinningType.THIRD]).isNull()
        assertThat(winningResult.result[LottoWinningType.FOURTH]).isNull()
        assertThat(winningResult.result[LottoWinningType.NONE]).isNull()
        assertThat(
            winningResult.profit,
        ).isEqualTo((LottoWinningType.FIRST.priceMoney + LottoWinningType.SECOND_WITH_BONUS.priceMoney) / purchaseLottoAmount.toDouble())
    }
}
