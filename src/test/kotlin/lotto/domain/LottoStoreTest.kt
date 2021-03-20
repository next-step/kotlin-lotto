package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoStoreTest {

    @Test
    fun `14000원을 주면 로또 14장을 살 수 있다`() {
        assertThat(LottoStore().getPurchasableLottoCount(14000)).isEqualTo(14)
    }

    @Test
    fun `로또를 10장 구입한다`() {
        assertThat(LottoStore().buyLotto(10).size).isEqualTo(10)
    }
}
