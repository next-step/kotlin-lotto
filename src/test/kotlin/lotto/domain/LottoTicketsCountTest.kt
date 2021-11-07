package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class LottoTicketsCountTest {

    @Test
    fun `자동으로 살 로또 갯수와 총 구매금액이 주어지면 자동 및 수동 로또 갯수를 구한다`() {
        // given
        val manualCount = LottoTicketCount(3)
        val totalMoney = LottoMoney(10000)

        // when
        val result = LottoTicketsCount.of(manualCount, totalMoney)

        // then
        assertThat(result.auto.value).isEqualTo(7)
        assertThat(result.manual.value).isEqualTo(3)
    }
}
