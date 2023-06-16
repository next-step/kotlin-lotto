package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `지난 주 당첨 번호와 몇 개가 일치하는지 확인할 수 있다`() {
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).checkEqualCount(Lotto(listOf(2, 3, 4, 5, 6, 7)))).isEqualTo(5)
    }
}
