package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizeTest {
    @Test
    internal fun `matchCount 3으로 검색하면 LottoPrize,FIFTH 반환한다`() {
        val matchCount = 3
        val actual = LottoPrize.values().find { it.matchCount == matchCount }
        assertThat(actual).isEqualTo(LottoPrize.FIFTH)
    }
}
