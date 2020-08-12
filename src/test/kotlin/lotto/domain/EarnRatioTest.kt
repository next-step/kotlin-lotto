package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EarnRatioTest {

    @Test
    fun `수익률을 제대로 계산하는지 확인`() {
        // given
        val useMoney = LottoMoney(14_000L)
        val results = LottoMoney(5_000L)

        val expectedRatio = "%.2f".format(5_000L.toDouble() / 14_000)

        // then
        assertThat(EarnRatio.calculate(useMoney, results)).isEqualTo(expectedRatio)
    }
}
