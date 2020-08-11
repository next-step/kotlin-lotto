package lotto

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @DisplayName("당첨 번호를 리스트에 담는다.")
    @Test
    fun `when input winning numbers than list size is six`() {
        val results = WinningNumbers.getInstance("1,2,3,4,5,6")
        assertThat(results.winningNumbers.size).isEqualTo(6)
    }

    @DisplayName("당첨 번호에 중복이 있으면 IllegalArgumentException을 던진다.")
    @Test
    fun `when input duplicated number than throw IllegalArgumentException`() {
        Assertions.assertThatThrownBy { WinningNumbers.getInstance("1,1,2,3,4,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("중복된 숫자는 입력할 수 없습니다.")
    }
}
