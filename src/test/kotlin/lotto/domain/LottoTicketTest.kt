package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTicketTest {

    @Test
    fun `로또 6자리 확인`() {
        assertThrows<IllegalArgumentException> { LottoTicket(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) }) }
    }

    @Test
    fun `1~45 까지 6자리의 숫자가 포함된 정상적인 상황 확인`() {
        val expected = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        assertThat(LottoTicket(expected).numbers).isEqualTo(expected)
    }
}
