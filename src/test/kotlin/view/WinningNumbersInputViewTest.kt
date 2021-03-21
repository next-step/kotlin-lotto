package view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class WinningNumbersInputViewTest {
    @Test
    fun `당첨번호입력뷰는 인자없이 생성된다`() {
        assertDoesNotThrow { WinningNumbersInputView() }
    }
}
