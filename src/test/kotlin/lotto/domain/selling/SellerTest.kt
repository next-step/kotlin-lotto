package lotto.domain.selling

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class SellerTest {
    private val seller = Seller()

    @DisplayName("지불 결과(거스름돈, 로또)를 반환한다")
    @Test
    fun processOrder() {
        val paymentResult = seller.processPayment(Payment(12300))
        assertThat(paymentResult.lottoTickets).hasSize(12).doesNotContainNull()
        assertThat(paymentResult.change).isEqualTo(300)
    }

    @DisplayName("받을 수 있는 금액인지 확인한다")
    @ParameterizedTest
    @ValueSource(strings = ["12000", "13330"])
    fun isAcceptable(money: String) {
        assertThat(seller.isAcceptable(money)).isTrue()
    }
}
