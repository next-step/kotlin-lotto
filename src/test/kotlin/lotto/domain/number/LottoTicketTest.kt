package lotto.domain.number

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 티켓은 6장의 중복되지 않은 숫자로 만들어진다`() {
        val lottoTicket = LottoTicket.from(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lottoTicket.numbers.size).isEqualTo(6)
    }

    @Test
    fun `중복된 숫자가 있는 경우 예외 발생`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { LottoTicket.from(listOf(1, 2, 3, 4, 5, 1)) }
    }

    @Test
    fun `6개 미만의 숫자로 만들 경우 예외 발생`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { LottoTicket.from(listOf(1, 2, 3, 4, 5)) }
    }

    @Test
    fun `6개 초과의 숫자로 만들 경우 예외 발생`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { LottoTicket.from(listOf(1, 2, 3, 4, 5, 6, 7)) }
    }
}
