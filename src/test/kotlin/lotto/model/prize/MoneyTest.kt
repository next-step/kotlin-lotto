package lotto.model.prize

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {

    @DisplayName(value = "0보다 작은 수일 경우, Exception")
    @Test
    fun minusMoneyTest() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                Money(-2)
            }
    }

    @DisplayName(value = "*(times) Test")
    @ParameterizedTest
    @ValueSource(ints = [12, 2, 4, 5, 1])
    fun moneyTimesTest(input: Int) {
        val money = 1_000
        assertThat((Money(money) * input).value).isEqualTo(Money(money * input).value)
    }

    @DisplayName(value = "0보다 작은 수를 연산할 때, Exception")
    @Test
    fun minusMoneyTimesTest() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                Money(1000) * -3
            }
    }

    @DisplayName(value = "*(times) Test")
    @ParameterizedTest
    @ValueSource(ints = [0, 1_000, 3_500, 500_000, 1_000_000])
    fun checkBuyLottoCount(input: Int) {
        val money = Money(input)
        assertThat(money.availableLottoCount()).isEqualTo(input / Money.LOTTO_PRICE)
    }
}
