package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또 데이터 발급`() {
        val lotto = Lotto(1, 45, 6)
        val lottoInfo: LottoData = lotto.issue()
        assertThat(lottoInfo.numbers.min()).isGreaterThanOrEqualTo(1)
        assertThat(lottoInfo.numbers.max()).isLessThanOrEqualTo(45)
        assertThat(lottoInfo.numbers.size).isEqualTo(6)
    }
}
