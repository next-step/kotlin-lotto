package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StoreTest {

    @Test
    fun `금액에 맞게 로또를 발급해준다`() {
        val lottos: List<Lotto> = Store().buy(Money(2000))
        assertThat(lottos.size).isEqualTo(2)
    }
}
