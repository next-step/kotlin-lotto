package lotto.data

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `보너스 번호가 로또번호와 중복되면 안된다`() {
        Assertions.assertThatThrownBy { WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
