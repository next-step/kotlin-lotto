package lotto.domain

import lotto.domain.strategy.OneToSixStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LottoTicketsTest {
    @DisplayName("개수를 인자로 넣은 경우 개수 만큼의 로또 티켓 반환")
    @Test
    fun create() {
        val actual = LottoTickets.create(2, OneToSixStrategy())

        assertAll(
            { assertThat(actual.tickets.size).isEqualTo(2) },
            { assertThat(actual.tickets[0].numbers.containsAll(createLotto(1, 2, 3, 4, 5, 6).numbers)).isTrue },
            { assertThat(actual.tickets[1].numbers.containsAll(createLotto(1, 2, 3, 4, 5, 6).numbers)).isTrue },
        )
    }

    @DisplayName("로또 숫자를 인자로 넣은 경우 티켓들의 일치 개수 반환")
    @Test
    fun getMatchCounts() {
        val tickets = LottoTickets.create(2, OneToSixStrategy())

        val actual = tickets.getMatchCounts(createLotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(listOf(6, 6))
    }
}
