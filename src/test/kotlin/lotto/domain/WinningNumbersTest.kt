package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `보너스 번호는 당첨 번호에 포함되면 안된다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { WinningNumbers(winningNumbers = listOf(1, 2, 3, 4, 5), bonusNumber = 1) }
            .withMessage("당첨 번호안에 보너스 번호가 포함되어 있습니다.")
    }
}
