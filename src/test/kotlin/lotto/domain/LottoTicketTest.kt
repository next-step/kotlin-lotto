package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    internal fun `로또 티켓 번호는 6개가 아니면 에외가 발생한다`() {
        // given

        // when, then
        assertThatIllegalArgumentException().isThrownBy { LottoTicket(1, 2, 3, 4, 5) }
        assertThatIllegalArgumentException().isThrownBy { LottoTicket(1, 2, 3, 4, 5, 6, 7) }
    }

    @Test
    internal fun `로또 티켓 번호중 중복된 번호가 있으면 에외가 발생한다`() {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy { LottoTicket(1, 1, 3, 4, 5, 6) }
    }

    @Test
    internal fun `값이 포함되어 있지 않으면 true를 반환한다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when, then
        assertThat(lottoTicket.notContainNumber(LottoNumber.of(7))).isTrue
    }

    @Test
    internal fun `값이 포함되어 있으면 false를 반환한다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when, then
        assertThat(lottoTicket.notContainNumber(LottoNumber.of(6))).isFalse
    }
}
