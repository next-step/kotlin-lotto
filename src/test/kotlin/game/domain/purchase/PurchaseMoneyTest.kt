package game.domain.purchase

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PurchaseMoneyTest {
    @Test
    fun `로또구입 금액은 최소 1000원 이상이어야 합니다`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { PurchaseMoney(999) }
    }

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "1999,1", "2000,2", "3000,3"])
    fun `로또구입 금액은 로또 구매 장수로 변환된다`(money: Long, count: Long) {
        assertThat(PurchaseMoney(money).getLottoPurchaseCount()).isEqualTo(count)
    }
}