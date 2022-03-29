package lotto.domain.money

import lotto.domain.money.BuyMoney.Companion.DEFAULT_TICKET_PRICE
import lotto.domain.money.BuyMoney.Companion.ERR_INVALID_MONEY_VALUE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또 복권을 구매할 때 사용할 객체 `BuyMoney` 테스트")
internal class BuyMoneyTest {

    @DisplayName("티켓 기본가인 ${DEFAULT_TICKET_PRICE}의 배수로 구성된 값이 주어지면 `Money` 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = [1_000, 2_000, 10_000, 15_000, 33_000, 78_000, 100_000, 1_500_000])
    fun `create Money if given value that is composed of a multiple of default ticket price`(givenMoney: Int) {
        // Arrange
        // Act
        val buyMoney = BuyMoney(givenMoney)

        // Assert
        assertThat(buyMoney.value).isEqualTo(givenMoney)
    }

    @DisplayName("주어지는 값이 `0`보다 작거나 같으면 `Money` 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = [-77_118_001, -227, -10, 0])
    fun `create Money if given value that is smaller than 0 or equal to 0`(givenMoney: Int) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            BuyMoney(givenMoney)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERR_INVALID_MONEY_VALUE)
    }

    @DisplayName("주어지는 값이 ${DEFAULT_TICKET_PRICE}의 배수가 아닌 경우 `Money` 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = [100, 390, 999, 1_205, 432_128, 100_000_001])
    fun `create Money if given value that is not composed of a multiple of ${DEFAULT_TICKET_PRICE}`(givenMoney: Int) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            BuyMoney(givenMoney)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERR_INVALID_MONEY_VALUE)
    }
}
