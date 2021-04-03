package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LottoTicketsTest {
    @DisplayName("개수를 인자로 넣은 경우 개수 만큼의 로또 티켓 반환")
    @Test
    fun create() {
        val actual = LottoTickets.create(LottoCount(2), ONE_TO_SIX)

        assertAll(
            { assertThat(actual.tickets.size).isEqualTo(2) },
            { assertThat(actual.tickets[0].numbers.containsAll(createLotto(1, 2, 3, 4, 5, 6).numbers)).isTrue },
            { assertThat(actual.tickets[1].numbers.containsAll(createLotto(1, 2, 3, 4, 5, 6).numbers)).isTrue },
        )
    }

    @DisplayName("로또 숫자를 인자로 넣은 경우 티켓들의 일치 개수 반환")
    @Test
    fun getMatchCounts() {
        val tickets = LottoTickets.create(LottoCount(2), ONE_TO_SIX)
        val bonusNumber = LottoNumber(7)

        val actual = tickets.getMatchInfos(createLotto(1, 2, 3, 4, 5, 6), bonusNumber)

        assertAll(
            { assertThat(actual.map { it.matchCount }).isEqualTo(listOf(6, 6)) },
            { assertThat(actual.map { it.hasBonus }).isEqualTo(listOf(false, false)) }
        )
    }

    @DisplayName("로또 티켓 두 장을 합친 새로운 로또 티켓 생성")
    @Test
    fun concat() {
        val tickets1 = LottoTickets(listOf(createLotto(1, 2, 3, 4, 5, 6)))
        val tickets2 = LottoTickets(listOf(createLotto(7, 8, 9, 10, 11, 12)))

        val actual = tickets1.concat(tickets2)

        assertAll(
            { assertThat(actual.tickets[0].numbers).containsAll(tickets1.tickets[0].numbers) },
            { assertThat(actual.tickets[1].numbers).containsAll(tickets2.tickets[0].numbers) }
        )
    }
}
