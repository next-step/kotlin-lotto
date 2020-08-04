package lotto.domain

import lotto.domain.EarnRatio
import lotto.domain.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EarnRatioTest {

    @Test
    fun `수익률을 제대로 계산하는지 확인`() {
        // given
        val useMoney = 14000
        val results = listOf(LottoResult.FOURTH)

        val expectedRatio = 5000.toDouble() / 14000
        // when

        // then
        assertThat(EarnRatio.calculate(useMoney, results)).isEqualTo(expectedRatio)
    }
}
