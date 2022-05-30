package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinnerNumbersTest {
    @Test
    fun `count`() {
        Assertions.assertThat(WinnerNumbers(listOf(1, 2, 3, 4, 5)).count { i -> i % 2 == 0 })
            .isEqualTo(2)
    }
}
