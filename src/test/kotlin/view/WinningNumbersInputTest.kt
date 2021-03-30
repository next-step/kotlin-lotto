package view

import domain.lotto.lottoNumberOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinningNumbersInputTest {
    @Test
    fun `당첨번호입력값은 로또숫자열로 변환할 수 있다`() {
        assertThat(WinningNumbersInput("1, 2, 3, 4, 5, 6", 7).toWinningNumbers().numbers)
            .isEqualTo(lottoNumberOf(1, 2, 3, 4, 5, 6))
        assertThat(WinningNumbersInput("9,7,17,45,2,32", 8).toWinningNumbers().numbers)
            .isEqualTo(lottoNumberOf(9, 7, 17, 45, 2, 32))
    }
}
