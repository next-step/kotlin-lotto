package lotto.domain

import lotto.domain.strategy.LottoNumberStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LottoTicketTest {
    @DisplayName("1 이상 45 이하의 숫자를 가진 로또 티켓 생성")
    @Test
    fun create() {
        val ticket = LottoTicket.create(LottoNumberStrategy())
        assertAll(
            { assertThat(ticket.numbers.size).isEqualTo(6) },
            { assertThat(ticket.numbers.all { it.number in 1..45 }).isTrue }
        )
    }
}
