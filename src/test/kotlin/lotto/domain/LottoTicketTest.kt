package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `로또 1장은 1000원이다`() {
        val price = LottoTicket.PRICE
        assertThat(price).isEqualTo(1000)
    }

    @Test
    fun `로또 1장은 로또 번호 6개로 이루어져 있다`() {
        val numbers = LottoTicket().getLottoNumbers()
        assertThat(numbers.size).isEqualTo(6)
    }
}
