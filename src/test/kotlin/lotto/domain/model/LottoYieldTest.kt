package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoYieldTest {
    @Test
    fun `LottoYield는 수익률을 보관한다`() {
        val lottoYield = LottoYield(2.0)

        assertThat(lottoYield.value).isEqualTo(2.0)
    }

    @ParameterizedTest
    @ValueSource(doubles = [0.3, 1.0, 5.0, 0.2])
    fun `isLoss를 통해 현재 손해가 났는지 확인할 수 있다`(input: Double) {
        val lottoYield = LottoYield(input)

        val expected = input < LottoYield.PROFIT_THRESHOLD

        assertThat(lottoYield.isLoss()).isEqualTo(expected)
    }
}
