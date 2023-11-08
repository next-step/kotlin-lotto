package lotto.dto

import lotto.domain.LottoNumbers.Companion.LOTTO_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ImmutableMoneyTest {
    @Test
    fun `음수 금액으로 ImmutableMoney 생성시 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            ImmutableMoney.of(-1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [2000, 3000, 4000, 5234])
    fun `로또를 사도 원래 금액은 변하지 않는다`(expected: Int) {
        val money = ImmutableMoney.of(expected)
        val remain = money.buy(1)
        assertThat(money.money).isEqualTo(expected)
        assertThat(remain.money).isEqualTo(expected - LOTTO_PRICE)
    }

    @Test
    fun `잔여 금액이 로또 구입 금액보다 작으면 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            ImmutableMoney.of(LOTTO_PRICE - 1).buy(1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [2000, 3000, 4000, 5234])
    fun `잔여 금액으로 로또를 전부 구매한다`(money: Int) {
        assertThat(ImmutableMoney.of(money).buyAll()).isEqualTo(money / LOTTO_PRICE)
    }
}
