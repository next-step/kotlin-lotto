package lotto.domain

import lotto.domain.LottoTickets
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTicketsTest {

    @ValueSource(ints = [1, 5, 14])
    @ParameterizedTest
    internal fun `로또 티켓이 생성된다`(size: Int) {
        // given
        // when
        val lottoTickets = LottoTickets.randomTickets(size)

        // then
        assertThat(lottoTickets.tickets).hasSize(size)
    }

    @ValueSource(ints = [0, -1])
    @ParameterizedTest
    internal fun `로또 티켓 생성시 0 또는 음수가 올 수없다`(input: Int) {
        // given

        // when, then
        assertThatIllegalArgumentException().isThrownBy { LottoTickets.randomTickets(input) }
    }
}
