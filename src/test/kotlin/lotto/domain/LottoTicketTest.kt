package lotto.domain

import lotto.domain.strategy.LottoNumberStrategy
import lotto.domain.strategy.OneToSixStrategy
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

    @DisplayName("로또 번호 리스트를 받아 일치하는 결과 수 반환")
    @Test
    fun getMatchCount() {
        val numbers = createLotto(1, 2, 3, 43, 44, 45)
        val ticket = LottoTicket.create(OneToSixStrategy())

        assertThat(ticket.getMatchCount(numbers)).isEqualTo(3)
    }
}
