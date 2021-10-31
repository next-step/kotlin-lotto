package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPurchaseInfoTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "100", "500", "999"])
    fun `로또 구입 구매 금액이 1000원 미만인데 수동 로또 구입 개수를 1로 입력하면 IllegalArgumentException이 발생한다`(amount: String) {
        Assertions.assertThatThrownBy {
            LottoPurchaseInfo.from(LottoPurchaseAmount.from(amount), LottoPurchaseCount(1))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "3000", "4000", "4999"])
    fun `로또 구입 구매 금액이 5000원 미만인데 수동 로또 구입 개수를 5로 입력하면 IllegalArgumentException이 발생한다`(amount: String) {
        Assertions.assertThatThrownBy {
            LottoPurchaseInfo.from(LottoPurchaseAmount.from(amount), LottoPurchaseCount(5))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 구입 구매 금액이 1000원이고 수동 로또 구입 개수를 1로 입력하면 자동 로또 구입 개수는 0이다`() {
        val purchaseInfo = LottoPurchaseInfo.from(LottoPurchaseAmount.from("1000"), LottoPurchaseCount(1))

        assertThat(purchaseInfo).isNotNull
        assertThat(purchaseInfo.manualPurchaseCount.value).isEqualTo(1)
        assertThat(purchaseInfo.automaticPurchaseCount.value).isEqualTo(0)
    }

    @Test
    fun `로또 구입 구매 금액이 10500원이고 수동 로또 구입 개수를 5로 입력하면 자동 로또 구입 개수는 5이다`() {
        val purchaseInfo = LottoPurchaseInfo.from(LottoPurchaseAmount.from("10500"), LottoPurchaseCount(5))

        assertThat(purchaseInfo).isNotNull
        assertThat(purchaseInfo.manualPurchaseCount.value).isEqualTo(5)
        assertThat(purchaseInfo.automaticPurchaseCount.value).isEqualTo(5)
    }
}
