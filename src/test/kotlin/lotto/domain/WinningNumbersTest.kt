@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `지난주 당첨 번호가 6개의 숫자가 아니면 IllegalArgumentException이 발생한다`() {
        val winningNumbers = (1..7).map(::LottoNumber)

        val actual = assertThrows<IllegalArgumentException> {
            WinningNumbers(winningNumbers)
        }

        assertThat(actual).hasMessageContaining("Winning numbers should be 6 numbers.")
    }
}
