package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoTicketTest {
    private val lottoTicket = LottoTicket(
        setOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3),
            LottoNumber(4), LottoNumber(5), LottoNumber(6)
        )
    )

    @DisplayName(value = "보너스 번호가 중복되면 예외 발생")
    @Test
    fun duplicateBonus() {
        assertThatThrownBy {
            WinningLottoTicket(lottoTicket, LottoNumber(4))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName(value = "보너스 번호가 포함 여부 확인")
    @Test
    fun hasBonus() {
        val winningLottoTicket = WinningLottoTicket(lottoTicket, LottoNumber(10))
        val userLottoTicket = LottoTicket(
            setOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(4), LottoNumber(5), LottoNumber(10)
            )
        )
        assertThat(winningLottoTicket.matchBonus(userLottoTicket)).isTrue()
    }
}
