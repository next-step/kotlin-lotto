package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `5500원으로 로또 구매시 5장의 로또를 구매한다`() {
        // given
        val price = 5_500

        // when
        val lottos = LottoMachine().buy(price)

        // then
        assertThat(lottos.lottos.size).isEqualTo(5)
    }
}
