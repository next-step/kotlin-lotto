package view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class BuyingResultViewTest {
    @Test
    fun `구매결과뷰는 인자없이 생성된다`() {
        assertDoesNotThrow { BuyingResultView() }
    }
}
