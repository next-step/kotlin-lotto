package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoShopTest {
    @ParameterizedTest
    @CsvSource("1000, 1", "2000 , 2", "3000, 3")
    fun `로또 1장의 가격은 1000원이다`(input: String, expected: String) {
        assertEquals(LottoShop.calculate(input.toInt()), expected.toInt())
    }

    @ParameterizedTest
    @CsvSource("1000, 1", "2000 , 2", "3000, 3")
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`(input: String, expected: String) {
        assertEquals(LottoShop.exchangeMoneyForLotto(input.toInt()).getLottoNumbers().size, expected.toInt())
    }
}
