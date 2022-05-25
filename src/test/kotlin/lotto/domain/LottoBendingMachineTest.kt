package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoBendingMachineTest {
    @Test
    fun `LottoBendingMachine은 건네준 금액에 맞는 수의 로또를 발급한다`() {
        val lottos = LottoBendingMachine.purchase(13500)

        assertThat(lottos.size).isEqualTo(13)
    }
}
