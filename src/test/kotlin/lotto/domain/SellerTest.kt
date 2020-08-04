package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class SellerTest {
    private val seller = Seller()

    @DisplayName(value = "발급할 로또의 갯수를 계산한다")
    @ParameterizedTest
    @ValueSource(ints = [10000])
    fun calculate(payment: Payment) {
        assertThat(seller.calculate(payment)).isEqualTo(PaymentResult(10, 0))
    }

    @DisplayName(value = "1000의 배수가 아닌 값을 받으면 거스름돈을 돌려준다")
    @ParameterizedTest
    @ValueSource(ints = [12300])
    fun calculateChange(payment: Payment) {
        assertThat(seller.calculate(payment)).isEqualTo(PaymentResult(12, 300))
    }
}
