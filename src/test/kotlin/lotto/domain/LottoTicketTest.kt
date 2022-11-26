package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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


    @ParameterizedTest
    @ValueSource(strings = ["10,11,12,13,14,15", "1,10,11,12,13,14", "1,2,10,11,12,13"])
    internal fun `번호가 2개 이하로 일치하면 NON_PLACE 이다`(input: String) {
        // given
        val lottoNumbers = input.split(",").map { LottoNumber.of(it.toInt()) }
        val lottoTicket = LottoTicket(lottoNumbers)
        val resultTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoTicket.matchScratch(resultTicket)

        // then
        assertThat(result).isEqualTo(Award.NON_PLACE)
    }

    @Test
    internal fun `값이 포함되어 있지 않으면 true를 반환한다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when, then
        assertThat(lottoTicket.notContainNumber(LottoNumber.of(7))).isTrue
        assertThat(lottoTicket.notContainNumber(LottoNumber.of(6))).isFalse
    }

    @Test
    internal fun `번호 3개가 일치하면 FIFTH_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 10, 11, 12)
        val resultTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoTicket.matchScratch(resultTicket)

        // then
        assertThat(result).isEqualTo(Award.FIFTH_PLACE)
    }

    @Test
    internal fun `번호 4개가 일치하면 FOURTH_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 11, 12)
        val resultTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoTicket.matchScratch(resultTicket)

        // then
        assertThat(result).isEqualTo(Award.FOURTH_PLACE)
    }


    @Test
    internal fun `번호 5개가 일치하면 THIRD_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 12)
        val resultTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoTicket.matchScratch(resultTicket)

        // then
        assertThat(result).isEqualTo(Award.THIRD_PLACE)
    }

    @Test
    internal fun `번호 6개가 일치하면 FIRST_PLACE 이다`() {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val resultTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoTicket.matchScratch(resultTicket)

        // then
        assertThat(result).isEqualTo(Award.FIRST_PLACE)
    }
}
