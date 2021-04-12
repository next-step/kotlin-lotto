package lotto.domain

import lotto.domain.LottoStore.LOTTO_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PurchaseAmountTest {
    @DisplayName("음수를 입력한 경우 예외 발생")
    @Test
    fun validateNegative() {
        assertThrows<IllegalArgumentException> { PurchaseAmount("-1") }
    }

    @DisplayName("숫자가 아닌 문자를 입력한 경우 예외 발생")
    @Test
    fun init() {
        assertThrows<NumberFormatException> { PurchaseAmount("a") }
    }

    @DisplayName("가격을 인자로 받아 구매할 로또의 개수 반환")
    @Test
    fun calculateLottoCount() {
        assertThat(PurchaseAmount("3000") / LOTTO_PRICE).isEqualTo(LottoCount(3))
    }
}
