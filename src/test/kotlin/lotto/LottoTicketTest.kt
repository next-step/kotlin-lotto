package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `로또 티켓 생성시 번호의 개수가 안맞으면 Exception`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5)
        )

        // then
        assertThatThrownBy { LottoTicket(lottoNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 반드시 6개 입니다.")
    }

    @Test
    fun `로또 티켓 생성시 중복 번호가 있으면 Exception`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(5)
        )

        // then
        assertThatThrownBy { LottoTicket(lottoNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }

    @Test
    fun `로또 티켓 비교시 원하는 결과가 나오는지 확인`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val lottoTicket1 = LottoTicket(lottoNumbers)
        val lottoTicket2 = LottoTicket(lottoNumbers)

        // then
        assertThat(lottoTicket1.compare(lottoTicket2)).isEqualTo(LottoResult.FIRST)
    }
}
