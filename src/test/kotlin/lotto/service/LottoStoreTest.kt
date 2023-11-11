package lotto.service

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStoreTest {
    @Test
    fun `4500원을 지불하면 4장의 로또를 구매할 수 있다`() {
        val lottoCount = LottoStore.getLottoCount(4500)
        assertThat(lottoCount).isEqualTo(4)
    }

    @Test
    fun `LottoCounter 에 돈을 지불하면 로또를 구매할 수 있다 (기본 가격은 1000원)`() {
        val lottos: List<Lotto> = LottoStore.purchase(15000)
        assertThat(lottos.size).isEqualTo(15)
    }

    @Test
    fun `LottoCounter 3500원을 지불하면 3000원 어치 로또를 구매한다 (기본 가격은 1000원)`() {
        val lottos: List<Lotto> = LottoStore.purchase(3500)
        assertThat(lottos.size).isEqualTo(3)
    }
}
