package lotto.domain

import fixture.WinningTicketFixture.winningTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinningTicketTest {

    @ParameterizedTest
    @ValueSource(strings = ["10,11,12,13,14,15", "1,10,11,12,13,14", "1,2,10,11,12,13"])
    internal fun `번호가 2개 이하로 일치하면 NON_PLACE 이다`(input: String) {
        // given
        val lottoNumbers = input.split(",").map { LottoNumber.of(it.toInt()) }
        val lottoTicket = LottoTicket(lottoNumbers)
        val winningTicket = winningTicket(listOf(1, 2, 3, 4, 5, 6), 45)

        // when
        val result = winningTicket.match(lottoTicket)

        // then
        assertThat(result).isEqualTo(Award.NON_PLACE)
    }

    @Test
    internal fun `번호 3개가 일치하면 FIFTH_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 10, 11, 12)
        val winningTicket = winningTicket(listOf(1, 2, 3, 4, 5, 6), 45)

        // when
        val result = winningTicket.match(lottoTicket)

        // then
        assertThat(result).isEqualTo(Award.FIFTH_PLACE)
    }

    @Test
    internal fun `번호 4개가 일치하면 FOURTH_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 11, 12)
        val winningTicket = winningTicket(listOf(1, 2, 3, 4, 5, 6), 45)

        // when
        val result = winningTicket.match(lottoTicket)

        // then
        assertThat(result).isEqualTo(Award.FOURTH_PLACE)
    }

    @Test
    internal fun `번호 5개가 일치하고 보너스 번호가 일치하지 않으면 THIRD_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 12)
        val winningTicket = winningTicket(listOf(1, 2, 3, 4, 5, 6), 45)

        // when
        val result = winningTicket.match(lottoTicket)

        // then
        assertThat(result).isEqualTo(Award.THIRD_PLACE)
    }

    @Test
    internal fun `번호 5개가 일치하고 보너스 번호가 일치 하면 SECOND_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 12)
        val winningTicket = winningTicket(listOf(1, 2, 3, 4, 5, 6), 12)

        // when
        val result = winningTicket.match(lottoTicket)

        // then
        assertThat(result).isEqualTo(Award.SECOND_PLACE)
    }

    @Test
    internal fun `번호 6개가 일치하면 FIRST_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val winningTicket = winningTicket(listOf(1, 2, 3, 4, 5, 6), 45)

        // when
        val result = winningTicket.match(lottoTicket)

        // then
        assertThat(result).isEqualTo(Award.FIRST_PLACE)
    }

    @Test
    internal fun `받을 수 있는 상금이 반환된다`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 4, 11, 12)
            )
        )

        val winningTicket = winningTicket(listOf(1, 2, 3, 4, 5, 6), 45)

        // when
        val result = winningTicket.awardResults(lottoTickets)

        // then
        assertAll(
            { assertThat(result.matchCount(Award.FIFTH_PLACE)).isEqualTo(2) },
            { assertThat(result.matchCount(Award.FOURTH_PLACE)).isEqualTo(1) },
            { assertThat(result.matchCount(Award.FIRST_PLACE)).isEqualTo(0) }
        )
    }
}
