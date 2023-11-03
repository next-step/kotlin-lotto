package lotto.business

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `서로 다른 로또 번호 6개로 티켓을 생성할 수 있다`() {
        // given
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }

        // when, then
        LottoTicket(lottoNumber)
    }

    @Test
    fun `서로 다른 로또 번호 6개가 아니면 예외를 던진다`() {
        // given
        val lottoNumber = listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) }

        // when, then
        assertThatThrownBy { LottoTicket(lottoNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("서로 다른 6개 로또 번호 이여야 합니다.")
    }
}
