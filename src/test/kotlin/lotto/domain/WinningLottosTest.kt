package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottosTest {

    @Test
    fun `당첨번호를 6개와 보너스 번호를 입력한다`() {
        // given
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 7

        // when
        val actual = WinningLotto.of(inputWinningNumber, bonusNumber).winningNumbers.size

        // then
        val expected = 6
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `당첨번호가 입력되지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(emptyList(), 7)
        }
    }

    @Test
    fun `당첨번호가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto.of(listOf("1", "2"), 7)
        }
    }

    @Test
    fun `당첨번호가 1에서 45숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto.of(listOf("1", "2", "3", "4", "5", "46"), 7)
        }
    }

    @Test
    fun `입력한 로또 번호에 보너스 번호가 포함될 경우 true`() {
        // given
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "7")
        val bonusNumber = 7

        // when
        val actual = WinningLotto.of(inputWinningNumber, bonusNumber).isMatchBonus(bonusNumber)

        // then
        assertThat(actual).isTrue
    }

    @Test
    fun `입력한 로또 번호에 보너스 번호가 포함되지 않은 경우 false`() {
        // given
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 7

        // when
        val actual = WinningLotto.of(inputWinningNumber, bonusNumber).isMatchBonus(8)

        // then
        assertThat(actual).isFalse
    }
}
