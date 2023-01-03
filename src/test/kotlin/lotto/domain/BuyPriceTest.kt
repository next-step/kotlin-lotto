package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class BuyPriceTest {

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "3000,3", "14000,14"])
    fun `1000원 단위로 n장의 로또가 생성된다`(input: String, expected: String) {
        // given
        val buyPrice = BuyPrice(input.toInt())

        // when
        val actual = buyPrice.getLottoCount()

        // then
        assertThat(actual).isEqualTo(expected.toInt())
    }
}
