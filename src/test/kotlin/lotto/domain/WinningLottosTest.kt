package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottosTest {

    @Test
    fun `당첨번호를 6개 입력한다`() {
        // given
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "6")

        // when
        val actual = WinningLotto(inputWinningNumber).winningNumbers.size

        // then
        val expected = 6
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `당첨번호가 입력되지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(emptyList())
        }
    }

    @Test
    fun `당첨번호가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf("1", "2"))
        }
    }

    @Test
    fun `당첨번호가 1에서 45숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf("1", "2", "3", "4", "5", "46"))
        }
    }
}
