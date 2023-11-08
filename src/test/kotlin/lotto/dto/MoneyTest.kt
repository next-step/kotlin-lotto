package lotto.dto

import lotto.domain.LottoNumbers.Companion.LOTTO_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @Test
    fun `금액이 음수이면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Money(-1)
        }
    }

    @Test
    fun `금액 이상 로또를 구매할 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Money(1000).buyLottos(2)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1234, 2830, 3000, 4000, 5000])
    fun `금액에 딱 맞춰서 로또를 구매한다`(money: Int) {
        assertThat(Money(money).buyAllLottos()).isEqualTo(money / LOTTO_PRICE)
    }

    @ParameterizedTest
    @CsvSource(value = ["1000, 0, 0", "1000, 2000, 2", "1000, 30, 0.03", "1000, 40000, 40", "1000, 5, 0.005"])
    fun `수익률을 구한다`(initMoney: Int, prizeMoney: Int, expected: Double) {
        assertThat(Money(initMoney).getROR(prizeMoney)).isEqualTo(expected)
    }
}
