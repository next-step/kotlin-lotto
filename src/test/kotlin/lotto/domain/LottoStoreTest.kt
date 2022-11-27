package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStoreTest {

    @Test
    fun `로또를 판매합니다`() {
        val store = LottoStore { Lotto.with(listOf(1, 2, 3, 4, 5, 6)) }

        assertThat(store.buy(14000).lottos).containsOnly(Lotto.with(listOf(1, 2, 3, 4, 5, 6)))
        assertThat(store.buy(14000).lottos.size).isEqualTo(14)
    }
}
