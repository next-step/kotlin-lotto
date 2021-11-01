package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTicketsTest {
    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4])
    fun `복권 여러장 사기`(input: Int) {
        assertThat(LottoTickets(input).tickets.size).isEqualTo(input)
    }
}
