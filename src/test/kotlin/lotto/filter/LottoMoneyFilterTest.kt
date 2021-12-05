package lotto.filter

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMoneyFilterTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "1001", "2500", "3500"])
    fun `로또 구매 금액이 천원단위가 아닐시 IllegalArgumentException 에러가 발생한다`(money: Int) {
        assertThrows<IllegalArgumentException> { LottoMoneyFilter.verify(money) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-999999", "-102031"])
    fun `로또 구매 금액에 음수로 들어오면 IllegalArgumentException 에러를 발생 한다`(money: Int) {
        assertThrows<IllegalArgumentException> { LottoMoneyFilter.verify(money) }
    }

}