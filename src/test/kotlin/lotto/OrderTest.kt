package lotto

import lotto.domain.Money
import lotto.domain.OrderSheet
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OrderTest {

    @ParameterizedTest
    @CsvSource("1100, 1, true", "900, 1, false")
    fun `수동 구매에 필요한 금액보다 구매 금액이 작을 경우 실패를 알려준다`(money: Int, count: Int, expected: Boolean) {
        val result = OrderSheet(Money(money), count, Money(1000))

        Assertions.assertThat(result.isValid()).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2000, 1, 1", "1100, 1, 0")
    fun `수동 구매를 제외한 금액만큼 자동구매한다`(money: Int, manualCount: Int, autoCount: Int) {
        val result = OrderSheet(Money(money), manualCount, Money(1000))

        Assertions.assertThat(result.auto).isEqualTo(autoCount)
    }
}
