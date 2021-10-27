package lotto

import lotto.model.Price
import lotto.model.Price.Companion.EXCEPTION_PRICE_FORMAT
import lotto.model.Price.Companion.EXCEPTION_PRICE_NULL
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @ValueSource(ints = [1000, 5000, 100000])
    @ParameterizedTest
    @DisplayName("구매 금액을 올바르게 입력한 경우")
    fun `correct purchase amount`(price: Int) {
        val sample = Price(price)

        assertThat(sample.price).isEqualTo(price)
    }

    @ValueSource(ints = [10, -199, 134256])
    @ParameterizedTest
    @DisplayName("구매 금액을 올바르게 입력하지 않은 경우")
    fun `incorrect purchase amount`(price: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ Price(price) }
            .withMessage(EXCEPTION_PRICE_FORMAT)
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("구매 금액을 입력하지 않은 경우")
    fun `null of purchase amount`(price: Int?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ Price(price) }
            .withMessage(EXCEPTION_PRICE_NULL)
    }


}