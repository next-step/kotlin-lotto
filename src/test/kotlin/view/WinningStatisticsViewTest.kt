package view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class WinningStatisticsViewTest {
    @Test
    fun `당첨통계뷰는 인자없이 생성된다`() {
        assertDoesNotThrow { WinningStatisticsView() }
    }
}
