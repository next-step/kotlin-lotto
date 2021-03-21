package view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

internal class BuyingInputViewTest {
    @Test
    fun `구매금액입력뷰는 인자없이 생성된다`() {
        assertDoesNotThrow { BuyingInputView() }
    }
}
