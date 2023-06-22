package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `구입금액을 1_000으로 나눈 몫만큼 로또를 생성한다`() {
        // given
        val price = 5_000

        // when
        val lottos = LottoMachine().buy(price)

        // then
        assertThat(lottos.lottos.size).isEqualTo(5)
    }
}
