package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResultTest {

    @Test
    fun `수익율 계산 테스트`() {
        assertThat(Result(mapOf(Pair(Rank.FIFTH, 5))).calculateYield(Money(10000))).isEqualTo(Yield(2.5))
    }
}
