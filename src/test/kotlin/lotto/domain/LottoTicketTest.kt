package lotto.domain

import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTicketTest {

    @DisplayName(value = "로또 번호는 6개의 숫자여야 한다.")
    @Test
    fun checkWinningCount() {
        assertThat(LottoTicket(LottoType.MANUAL, 10, 20)).isNull()
    }

    @DisplayName(value = "모든 로또 번호는 서로 다른 숫자여야 한다.")
    @Test
    fun checkWinningDuplicate() {
        assertThat(LottoTicket(LottoType.MANUAL, 1, 2, 3, 4, 5, 5)).isNull()
    }
}
