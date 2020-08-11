package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTicketTest {

    @DisplayName(value = "6개가 아닌 로또 번호를 입력했을 때 예외 발생")
    @Test
    fun checkWinning() {
        Assertions.assertThatThrownBy {
            LottoTicket(setOf(LottoNumber(10), LottoNumber(20)))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
