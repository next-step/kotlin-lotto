package lotto

import lotto.model.Buyer
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BuyerTest {
    @Test
    fun `로또 구매`() {
        val buyer = Buyer()

        buyer.buyAll(14_000)

        Assertions.assertThat(buyer.purchasedLottos.size).isEqualTo(14)
    }

    @Test
    fun `로또 구매 금액이 부족한 경우`() {
        val buyer = Buyer()

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            buyer.buyAll(900)
        }
    }
}
