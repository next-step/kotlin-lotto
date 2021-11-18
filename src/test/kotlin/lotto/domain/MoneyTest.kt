package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {

    @Test
    fun `로또 최소 금액은 천원 이상`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Money.makeForBuyingLotto(800) }
            .withMessage("최소 금액은 1000원입니다.")
    }

    @Test
    fun `로또 금액 단위는 천원`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Money.makeForBuyingLotto(1800) }
            .withMessage("금액 단위는 1000원입니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000, 5000])
    fun `1000원당 로또 1장`(input: Int) {
        assertThat(Money.makeForBuyingLotto(input).convertToLottoTicketCount()).isEqualTo(input / 1000)
    }
}
