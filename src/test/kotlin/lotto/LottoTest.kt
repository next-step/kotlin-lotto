package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 구매금액을 입력받는다`() {
        val lotto = Lotto(5000)
        assertThat(lotto.purchasePrice).isEqualTo(5000)
    }
}
