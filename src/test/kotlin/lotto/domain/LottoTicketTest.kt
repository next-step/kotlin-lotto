package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.27..
 */
class LottoTicketTest {
    @ParameterizedTest
    @ValueSource(strings = ["0, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 46"])
    internal fun `로또에 숫자가 1보다 작거나 45보다 크다면 IllegalArgumentException을 던진다`(source: String) {
        assertThrows<IllegalArgumentException> {
            LottoTicket.of(source.split(", ").map { it.toInt() })
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2, 2, 3, 4, 5, 6"])
    internal fun `로또번호는 중복이 되면 IllegalArgumentException을 던진다`(source: String) {
        assertThrows<IllegalArgumentException> {
            LottoTicket.of(source.split(", ").map { it.toInt() })
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6"])
    internal fun `로또번호와 당첨번호가 같을경우 6을 반환한다`(source: String) {
        val ticketNumbers = LottoTicket.of(source.split(", ").map { it.toInt() })
        assertThat(ticketNumbers.getMatchCount(ticketNumbers)).isEqualTo(6)
    }
}
