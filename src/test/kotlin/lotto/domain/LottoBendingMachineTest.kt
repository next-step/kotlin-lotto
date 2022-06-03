package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoBendingMachineTest {
    @Test
    fun `LottoBendingMachine은 건네준 금액에 맞는 수의 로또를 발급한다`() {
        val lottos = LottoBendingMachine.purchase(
            13500,
            object : LottoFactory {
                override fun create(): Lotto {
                    return Lotto.from(1, 2, 3, 4, 5, 6)
                }
            }
        )

        assertThat(lottos.value.size).isEqualTo(13)
    }
}
