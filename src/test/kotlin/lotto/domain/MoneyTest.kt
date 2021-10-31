package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun `로또 최소 금액은 천원 이상`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Money.make(800) }
            .withMessage("최소 금액은 1000원입니다.")
    }

    @Test
    fun `로또 금액 단위는 천원`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Money.make(1800) }
            .withMessage("금액 단위는 1000원입니다.")
    }
}
