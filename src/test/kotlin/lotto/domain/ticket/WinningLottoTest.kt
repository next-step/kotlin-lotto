package lotto.domain.ticket

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {
    @Test
    fun `보너스 번호는 우승 티켓과 겹쳐선 안된다`() {
        // given
        val bonusNumber = LottoNumber.of(1)
        // when

        // then
        assertThrows<IllegalArgumentException> {
            WinningLotto(
                WinningLottoTicket(
                    listOf(
                        LottoNumber.of(1),
                        LottoNumber.of(12),
                        LottoNumber.of(13),
                        LottoNumber.of(14),
                        LottoNumber.of(15),
                        LottoNumber.of(16)
                    )
                ),
                bonusNumber
            )
        }.run {
            assertThat(this).hasMessage("보너스 번호($bonusNumber)는 우승 번호와 겹칠수 없습니다.")
        }
    }
}
