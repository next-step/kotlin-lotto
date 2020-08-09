package lotto

import lotto.model.Buyer
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BuyerTest {
    @Test
    fun `로또 구매`() {
        val buyer = Buyer(14_000).apply { buyLotto() }

        Assertions.assertThat(buyer.autoLotto.size).isEqualTo(14)
    }

    @Test
    fun `로또 구매 금액이 부족한 경우`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Buyer(900)
        }
    }
}
