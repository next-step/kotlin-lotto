package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `WinningNumbers는 당첨 번호 목록을 보관한다`() {
        val numbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val winningNumbers = WinningNumbers(numbers)

        assertThat(winningNumbers.value).isEqualTo(numbers)
    }

    @Test
    fun `WinningNumbers의 숫자가 6개가 아니면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf(1, 2, 3, 4, 5))
        }
    }
}
