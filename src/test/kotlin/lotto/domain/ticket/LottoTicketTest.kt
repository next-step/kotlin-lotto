package lotto.domain.ticket

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTicketTest {
    @Test
    fun `로또 티켓은 중복되지 않은 6개의 숫자로 이루어져야만 한다`() {
        // given

        // when

        // then
        assertThrows<IllegalArgumentException> {
            LottoTicket(
                setOf(
                    LottoNumber.of(1),
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5)
                )
            )
        }.run { assertThat(this).hasMessageContaining("로또 티켓은 중복되지 않은 6개의 숫자로 이루어져야 합니다.") }
    }
}
