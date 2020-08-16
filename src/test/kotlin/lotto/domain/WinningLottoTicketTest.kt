package lotto.domain

import lotto.domain.lotto.LottoNumber
import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType
import lotto.domain.lotto.WinningLottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoTicketTest {
    private lateinit var lottoTicket: LottoTicket

    @BeforeEach
    fun setUp() {
        lottoTicket = LottoTicket(LottoType.MANUAL, 1, 2, 3, 4, 5, 6)!!
    }

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
        val userLottoTicket = LottoTicket(LottoType.MANUAL, 1, 2, 3, 4, 5, 10)!!
        assertThat(winningLottoTicket.matchBonus(userLottoTicket)).isTrue()
    }
}
