package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoFactory
import lotto.domain.model.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoBendingMachineTest {
    @Test
    fun `LottoBendingMachine은 건네준 금액에 맞는 수의 로또를 발급한다`() {
        val lottoReceipt = LottoBendingMachine.purchaseAutomaticLottos(
            Money.from(13500),
            object : LottoFactory {
                override fun create(): Lotto {
                    return Lotto.from(1, 2, 3, 4, 5, 6)
                }
            }
        )

        assertAll(
            { assertThat(lottoReceipt.manualLottoCount.value).isZero },
            { assertThat(lottoReceipt.automaticLottoCount.value).isEqualTo(13) },
            { assertThat(lottoReceipt.lottos.value).hasSize(13) }
        )
    }
}
