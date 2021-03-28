package lotto.view.output

import lotto.view.ouput.LottoRate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRateTests {
    @Test
    fun `14000원 투자해서 5000원을 얻으면 수익률은 0,35퍼이다`() {
        val lottoRate: LottoRate = LottoRate(5000, 14000)

        assertThat((lottoRate.rate * 100).toInt())
            .isEqualTo(35)
    }
}
