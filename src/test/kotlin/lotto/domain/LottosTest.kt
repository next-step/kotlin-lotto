package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {

    @Test
    internal fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`() {
        val lottos = Lottos.buyRandom(3_000)
        assertThat(lottos.size).isEqualTo(3)
    }
}
