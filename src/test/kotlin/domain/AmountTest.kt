package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AmountTest {
    @Test
    fun successCase() {
        val amount = Amount(14123)

        assertThat(amount.getPurchaseLottoCount()).isEqualTo(14)
        assertThat(amount.getChange()).isEqualTo(123)
        assertThat(amount.getPurchaseAmount()).isEqualTo(14000)
    }

    @Test
    fun failureCase() {
        try {
            Amount(0)
        } catch (e: IllegalArgumentException) {
            assertThat(e.message).isEqualTo("구매 금액은 0원보다 커야 합니다. 입력한 구매금액: 0")
        }
    }
}
