package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPurchaserTest {
    @DisplayName(value = "입력받은 금액만큼의 로또를 구매한다.")
    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 100000])
    fun lottoNumberOutOfRange(amount: Int) {
        val lottoPurchaser = LottoPurchaser(AutoLottoGenerator())
        val purchasedAmount = lottoPurchaser.purchase(amount).size
        Assertions.assertThat(purchasedAmount).isEqualTo(amount / Lotto.PRICE)
    }
}