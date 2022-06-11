package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoWinningTest {
    private val lottoWinning = LottoWinning(
        numbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) },
        bonusNumber = LottoNumber(10)
    )

    @Test
    fun `티켓 정보를 통해 당첨 상금을 확인한다`() {
        assertThat(
            lottoWinning.getPrizes(
                lottoTickets = LottoTickets(
                    listOf(
                        LottoTicket(listOf(1, 2, 3, 14, 15, 16).map { LottoNumber(it) }),
                        LottoTicket(listOf(1, 2, 3, 4, 15, 16).map { LottoNumber(it) }),
                        LottoTicket(listOf(1, 2, 3, 4, 5, 16).map { LottoNumber(it) }),
                        LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                        LottoTicket(listOf(1, 2, 3, 4, 5, 10).map { LottoNumber(it) }),
                    )
                )
            )
        ).isEqualTo(
            LottoPrizes(listOf(LottoPrize.THIRD, LottoPrize.FORTH, LottoPrize.FIFTH, LottoPrize.SIXTH, LottoPrize.FIFTH_BONUS))
        )
    }
}
