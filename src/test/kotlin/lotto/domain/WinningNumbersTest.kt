@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `지난주 당첨 번호가 6개의 숫자가 아니면 IllegalArgumentException이 발생한다`() {
        val winningNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
            LottoNumber(7),
        )

        val actual = catchThrowable {
            WinningNumbers(winningNumbers)
        }

        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Winning numbers should be 6 numbers.")
    }
}
