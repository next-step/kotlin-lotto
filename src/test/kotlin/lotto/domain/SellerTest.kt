package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class SellerTest {
    private val seller = Seller()

    @DisplayName(value = "지불 결과(거스름돈, 로또)를 반환한다")
    @Test
    fun processOrder() {
        val paymentResult = seller.processOrder(12300)
        assertThat(paymentResult.lottoes).hasSize(12).doesNotContainNull()
        assertThat(paymentResult.change).isEqualTo(300)
    }
}
