package autolotto

import autolotto.vo.WinningLotto
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class WinningLottoTest {
    @Test
    fun `당첨번호를 입력받는다`() {
        // Given
        val input = "1, 2, 3, 4, 5, 6"

        // When
        val winningLotto = WinningLotto(input)

        // Then
        winningLotto.numbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `당첨번호가 숫자가 아닌 경우 throw IllegalArgumentException`() {
        // Given
        val input = "1, 2, 3, 4, 5, a"

        // Then
        assertThrows<IllegalArgumentException> { WinningLotto(input) }
    }

    @Test
    fun `당첨번호가 중복된 경우 throw IllegalArgumentException`() {
        // Given
        val input = "1, 1, 2, 2, 3, 3"

        // Then
        assertThrows<IllegalArgumentException> { WinningLotto(input) }
    }
}
