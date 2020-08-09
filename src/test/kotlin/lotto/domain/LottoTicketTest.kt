package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTicketTest {

    @Test
    fun `로또 티켓 생성시 번호의 개수가 안맞으면 Exception`() {
        // then
        assertThatThrownBy { LottoTicket(1, 2, 3, 4, 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 반드시 6개 입니다.")
    }

    @Test
    fun `로또 티켓 생성시 중복 번호가 있으면 Exception`() {
        // then
        assertThatThrownBy { LottoTicket(1, 2, 3, 4, 5, 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }

    @Test
    fun `로또 티켓 비교시 원하는 결과가 나오는지 확인`() {
        // given
        val lottoTicket1 = LottoTicket(1, 2, 3, 4, 5, 6)
        val lottoTicket2 = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val compareResult = lottoTicket1.getLottoResultWith(lottoTicket2, LottoNumber.of(7))

        // then
        assertThat(compareResult).isEqualTo(LottoResult.FIRST)
    }

    @CsvSource("1,true", "3,true", "7,false", "9,false")
    @ParameterizedTest
    fun `로또 티켓에 특정 숫자가 있는지 검사`(number: Int, hasNumber: Boolean) {
        // given
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val lottoNumber = LottoNumber.of(number)

        // then
        assertThat(lottoTicket.has(lottoNumber)).isEqualTo(hasNumber)
    }
}
