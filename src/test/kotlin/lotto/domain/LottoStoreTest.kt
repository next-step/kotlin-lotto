package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStoreTest {

    @Test
    fun `로또를 판매합니다`() {
        val store = LottoStore { Lotto.of(listOf(1, 2, 3, 4, 5, 6)) }

        val lottos = store.buy(14000).lottos

        assertThat(lottos).containsOnly(Lotto.of(listOf(1, 2, 3, 4, 5, 6)))
        assertThat(lottos.size).isEqualTo(14)
    }
}
