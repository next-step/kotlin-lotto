package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {
    @Test
    fun lottoTicket() {
        val actual = LottoTicket(6).lottos
        val expect = List(6) { Lotto(1, 2, 3, 4, 5, 6) }
        assertThat(actual).isEqualTo(expect)
    }
}
