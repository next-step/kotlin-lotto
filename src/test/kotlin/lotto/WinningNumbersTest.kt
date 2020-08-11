package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class WinningNumbersTest {
    private val winningNumbers = WinningNumbers.getInstance(
        listOf(1, 2, 3, 4, 5, 6)
    )

    @DisplayName("당첨 번호 목록을 입력하면 WinningNumbers 를 반환한다.")
    @Test
    fun `when input winning number list than return WinningNumbers object`() {
        assertThat(winningNumbers).isInstanceOf(WinningNumbers::class.java)
    }

    @DisplayName("당첨 번호에 로또 번호가 포함되어 있으면 true, 없으면 false를 반환한다.")
    @Test
    fun `when winning number includes the lotto number than return true, if not false`() {
        assertAll(
            { assertThat(winningNumbers.isContained(1)).isTrue() },
            { assertThat(winningNumbers.isContained(7)).isFalse() }
        )
    }
}
