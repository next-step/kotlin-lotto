package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinningCategoryTest {
    @Test
    fun `당첨항목은 '3개 일치', '4개 일치', '5개 일치', '6개 일치'가 있다`() {
        assertThat(WinningCategory.values().map { it.name })
            .containsExactly(
                "THREE_CORRECT",
                "FOUR_CORRECT",
                "FIVE_CORRECT",
                "SIX_CORRECT"
            )

        assertThat(WinningCategory.THREE_CORRECT.numberOfMatched).isEqualTo(3)
        assertThat(WinningCategory.FOUR_CORRECT.numberOfMatched).isEqualTo(4)
        assertThat(WinningCategory.FIVE_CORRECT.numberOfMatched).isEqualTo(5)
        assertThat(WinningCategory.SIX_CORRECT.numberOfMatched).isEqualTo(6)
    }
}
