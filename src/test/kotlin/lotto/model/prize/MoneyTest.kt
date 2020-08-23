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

    @DisplayName(value = "금액에 따른 구매가능한 로또의 수")
    @ParameterizedTest
    @ValueSource(ints = [0, 1_000, 3_500, 500_000, 1_000_000])
    fun checkAvailableLottoCountt(input: Int) {
        val money = Money(input)
        assertThat(money.availableLottoCount()).isEqualTo(input / Money.LOTTO_PRICE)
    }

    @DisplayName(value = "로또를 구매한 만큼 ,금액은 줄어든다.")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4])
    fun checkBuyLotto(input: Int) {
        val price = 5_000
        val money = Money(price)
        money.buyLottos(input)
        assertThat(money.value).isEqualTo(price - (Money.LOTTO_PRICE * input))
    }

    @DisplayName(value = "구매 가능한 로또 갯수보다, 많은 로또를 구매할 경우 ,RuntimeException")
    @Test
    fun checkBuyLotto() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                Money(1000).run {
                    buyLottos(10)
                }
            }
    }
}
