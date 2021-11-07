package lotto.domain

import lotto.domain.LottoTicketCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class LottoTicketCountTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 10])
    fun `0장 이상의 갯수로 Count를 생성한다`(count: Int) {
        // when
        val create = { LottoTicketCount(count) }

        // then
        assertDoesNotThrow(create)
    }

    @Test
    fun `count로 음수는 허용하지 않는다`() {
        // given
        val count = -1

        // when
        val create: () -> Unit = { LottoTicketCount(count) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 10])
    fun `티켓이 1장 이상 있다면 남아있다`(ticketCount: Int) {
        // given
        val count = LottoTicketCount(ticketCount)

        // when
        val result = count.isTicketRemain()

        // then
        assertThat(result).isTrue
    }

    @Test
    fun `티켓이 0장 이라면 있다면 남아있지 않다`() {
        // given
        val count = LottoTicketCount(0)

        // when
        val result = count.isTicketRemain()

        // then
        assertThat(result).isFalse
    }

    @Test
    fun `티켓을 사용하면 1장이 줄어든다`() {
        // given
        val count = LottoTicketCount(5)

        // when
        val result = count.useTicket()

        // then
        assertThat(result.value).isEqualTo(4)
    }

    @Test
    fun `티켓이 남아있지 않다면 티켓을 사용할 수 없다`() {
        // given
        val count = LottoTicketCount(0)

        // when
        val use: () -> Unit = { count.useTicket() }

        // then
        assertThrows<IllegalStateException>(use)
    }
}
