package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoProviderTest {
    @Test
    fun `구입금액으로 살 수 있는 로또 개수를 계산할 수 있다`() {
        val payment = 14300

        assertThat(LottoProvider(payment).numberOfLottos).isEqualTo(14)
    }

    @Test
    fun `구입한 로또의 수 만큼 로또를 생성한다`() {
        val payment = 20500
        val provider = LottoProvider(payment)

        assertThat(provider.lottos).hasSize(provider.numberOfLottos)
    }

    @Test
    fun `구입 금액이 로또 금액보다 낮다면 로또를 살 수 없다`() {
        val provider = LottoProvider(0)

        assertThat(provider.numberOfLottos).isEqualTo(0)
    }
}
