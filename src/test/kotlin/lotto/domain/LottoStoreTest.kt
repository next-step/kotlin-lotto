package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStoreTest{

    @Test
    fun `로또를 판매합니다`() {
        val store = LottoStore(RandomLottoGenerator())

        assertThat(store.buy(14000).size).isEqualTo(14);
    }
}
