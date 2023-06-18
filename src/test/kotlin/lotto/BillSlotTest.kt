package lotto

import lotto.domain.BillSlot
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class BillSlotTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `로또 가격이 0보다 작거나 같다면 throw IllegalArgumentException`(lottoPrice: Int) {
        assertThrows<IllegalArgumentException> {
            BillSlot(lottoPrice)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "14000, 1000, 14",
        "1300, 1000, 1",
        "1000, 2000, 0",
    )
    fun `주어진 금액으로 구입할 수 있는 로또 개수 구하기 테스트`(money: Int, lottoPrice: Int, numOfLotto: Int) {
        val billSlot = BillSlot(lottoPrice = lottoPrice)
        Assertions.assertThat(billSlot.insertMoney(money))
            .isEqualTo(numOfLotto)
    }
}
