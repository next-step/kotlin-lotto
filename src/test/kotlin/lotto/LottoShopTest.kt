package lotto

import lotto.domain.LottoShop
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoShopTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "1001", "2500", "3500"])
    fun `로또 구매 금액이 천원단위로 들어오는지 테스트한다 천원단위가 아닐시 IllegalArgumentException 에러가 발생한다`(money: Int) {
        assertThrows<IllegalArgumentException> { LottoShop.createLottoTicket(money) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-999999", "-102031"])
    fun `로또 구매 금액에 음수로 들어오면 IllegalArgumentException 에러를 발생 한다`(money: Int) {
        assertThrows<IllegalArgumentException> { LottoShop.createLottoTicket(money) }
    }

    @ParameterizedTest
    @CsvSource(value = ["10000|10", "140000|140"], delimiterString = "|")
    fun `로또 구매시 금액에 맞게 올바르게 생성되는지 테스트 한다`(money: Int, result: Int) {
        assertThat(LottoShop.createLottoTicket(money).size).isEqualTo(result)
    }
}
