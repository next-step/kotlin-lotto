package lotto.domain

import lotto.domain.generator.ManualLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTicketTest {

    @DisplayName(value = "번호가 일치하는 개수를 반환한다.")
    @Test
    fun checkWinning() {
        val winningLotto = LottoTicket(ManualLottoGenerator("1, 2, 3, 4, 5, 6"))
        val myLotto = LottoTicket(ManualLottoGenerator("1, 2, 3, 7, 8, 9"))
        assertThat(winningLotto.getMatchCount(myLotto)).isEqualTo(3)
    }
}
