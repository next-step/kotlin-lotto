package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPurchaseCountTest {
    @ParameterizedTest
    @ValueSource(strings = ["1000", "1001", "1100", "1500", "1999"])
    fun `1_000원 이상 2_000원 미만의 금액을 입력하면 로또 1장을 구입할 수 있다`(amount: String) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount.from(amount))

        assertThat(count.value).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["10000", "10001", "10050", "10100", "10999"])
    fun `10_000원 이상 11_000원 미만의 금액을 입력하면 로또 10장을 구입할 수 있다`(amount: String) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount.from(amount))

        assertThat(count.value).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["99000", "99001", "99050", "99100", "99999"])
    fun `99_000원 이상 100_000원 미만의 금액을 입력하면 로또 99장을 구입할 수 있다`(amount: String) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount.from(amount))

        assertThat(count.value).isEqualTo(99)
    }

    @ParameterizedTest
    @ValueSource(strings = ["100000"])
    fun `100_000원의 금액을 입력하면 로또 100장을 구입할 수 있다`(amount: String) {
        val count = LottoPurchaseCount.from(LottoPurchaseAmount.from(amount))

        assertThat(count.value).isEqualTo(100)
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["!", "abc", "테스트"])
    fun `빈문자열이나 숫자가 아닌 문자열을 입력하면 IllegalArgumentException이 발생한다`(count: String) {
        Assertions.assertThatThrownBy {
            LottoPurchaseCount.from(count)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "10", "100"])
    fun `0이상의 숫자를 입력하면 로또를 해당 숫자만큼 구입할 수 있다`(count: String) {
        val purchaseCount = LottoPurchaseCount.from(count)
        assertThat(purchaseCount.value).isEqualTo(count.toInt())
    }
}
