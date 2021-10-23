package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPurchaseCountTest {

    @ParameterizedTest
    @ValueSource(ints = [1000, 1001, 1100, 1500, 1999])
    fun `1_000원 이상 2_000원 미만의 금액을 입력하면 로또 1장을 구입할 수 있다`(amount: Int) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount(amount))

        assertThat(count.value).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [10_000, 10_001, 10_050, 10_100, 10_999])
    fun `10_000원 이상 11_000원 미만의 금액을 입력하면 로또 10장을 구입할 수 있다`(amount: Int) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount(amount))

        assertThat(count.value).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(ints = [99_000, 99_001, 99_050, 99_100, 99_999])
    fun `99_000원 이상 100_000원 미만의 금액을 입력하면 로또 99장을 구입할 수 있다`(amount: Int) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount(amount))

        assertThat(count.value).isEqualTo(99)
    }

    @ParameterizedTest
    @ValueSource(ints = [100_000])
    fun `100_000원의 금액을 입력하면 로또 100장을 구입할 수 있다`(amount: Int) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount(amount))

        assertThat(count.value).isEqualTo(100)
    }
}
