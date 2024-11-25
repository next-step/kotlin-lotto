package lotto

import lotto.domain.LottoPurchaseInfo
import lotto.domain.LottoTickets
import lotto.domain.WinningLottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `로또 금액과 수동 로또 개수를 입력받아 로또티켓을 만든다`() {
        val money = 14_000
        val manualLottoCount = 3
        val manualNumbers =
            listOf(
                setOf(1, 2, 3, 4, 5, 6),
                setOf(7, 8, 9, 10, 11, 12),
                setOf(13, 14, 15, 16, 17, 18),
            )

        val lottoPurchaseInfo = LottoPurchaseInfo(money, manualLottoCount)
        val lottoTickets = LottoTickets(lottoPurchaseInfo, manualNumbers)

        assertThat(lottoTickets.autoTickets.size).isEqualTo(11)
        assertThat(lottoTickets.manualTickets.size).isEqualTo(3)
    }

    @Test
    fun test() {
        val winningLottoTicket = WinningLottoTicket(
            winningNumbers = setOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7,
        )

        val lottoTickets = LottoTickets(
            LottoPurchaseInfo(
                money = 6_000,
                manualLottoCount = 6,
            ),
            manualNumbers =
            listOf(
                setOf(1, 2, 3, 4, 5, 6),
                setOf(1, 2, 3, 4, 5, 7),
                setOf(1, 2, 3, 4, 5, 8),
                setOf(1, 2, 3, 4, 8, 9),
                setOf(1, 2, 3, 10, 11, 12),
                setOf(25, 26, 27, 28, 29, 30),
            ),
        )

        val profitRate = winningLottoTicket.getProfitRate(lottoTickets)

        assertThat(profitRate).isEqualTo(338592.5)
    }
}
