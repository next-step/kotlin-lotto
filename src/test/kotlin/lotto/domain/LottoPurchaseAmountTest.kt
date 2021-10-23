package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPurchaseAmountTest {

    @ParameterizedTest
    @EmptySource
    fun `로또 구입 금액으로 null 이나 빈 문자열을 입력하면 IllegalArgumentException을 발생시킨다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoPurchaseAmount.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "!", "테스트"])
    fun `로또 구입 금액으로 숫자가 아닌 값을 입력하면 IllegalArgumentException을 발생시킨다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoPurchaseAmount.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "999", "100001", "101000"])
    fun `로또 구입 금액으로 1000원 미만이나 10만원초과의 금액을 입력하면 IllegalArgumentException을 발생시킨다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoPurchaseAmount.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "5000", "10000", "100000"])
    fun `로또 구입 금액으로 1000원 이상 10만원이하의 금액을 입력하면 IllegalArgumentException을 발생시킨다`(input: String) {
        val amount = LottoPurchaseAmount.from(input)

        assertThat(amount).isNotNull
        assertThat(amount.value).isEqualTo(input.toInt())
    }
}
