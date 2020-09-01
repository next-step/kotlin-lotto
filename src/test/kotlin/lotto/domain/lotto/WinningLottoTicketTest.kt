package lotto.domain.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoTicketTest {
    private lateinit var lottoTicket: LottoTicket

    @BeforeEach
    fun setUp() {
        lottoTicket = LottoTicket.of(LottoType.MANUAL, 1, 2, 3, 4, 5, 6)!!
    }

    @DisplayName(value = "보너스 번호가 중복되면 예외 발생")
    @Test
    fun duplicateBonus() {
        assertThat(WinningLottoTicket.of(lottoTicket, 4)).isNull()
    }

    @DisplayName(value = "보너스 번호가 포함 여부 확인")
    @Test
    fun hasBonus() {
        val winningLottoTicket = WinningLottoTicket.of(lottoTicket, 10)
        val userLottoTicket = LottoTicket.of(LottoType.MANUAL, 1, 2, 3, 4, 5, 10)!!
        assertThat(winningLottoTicket?.matchBonus(userLottoTicket)).isTrue()
    }
}
