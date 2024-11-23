package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {

    @Test
    fun `로또 금액과 수동 로또 개수를 입력받아 로또티켓을 만든다`() {
        val money = 14_000
        val manualLottoCount = 3
        val manualNumbers = listOf(
            setOf(1, 2, 3, 4, 5, 6),
            setOf(7, 8, 9, 10, 11, 12),
            setOf(13, 14, 15, 16, 17, 18)
        )

        val lottoTickets = LottoTickets(money, manualLottoCount, manualNumbers)

        assertThat(lottoTickets.autoTickets.size).isEqualTo(11)
        assertThat(lottoTickets.manualTickets.size).isEqualTo(3)

    }
}