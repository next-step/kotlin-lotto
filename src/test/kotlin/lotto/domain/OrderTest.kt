package lotto.domain

import lotto.fixture.LottoNumbersFixture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OrderTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2", "2,3", "0,100"])
    fun `예산을 초과하여 구매할 수 없다`(total: Int, manual: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Order.of(total, manual, LottoNumbersFixture.수동으로_선택된_로또번호_목록(manual)) }
    }

    @ParameterizedTest
    @CsvSource(value = ["2,1,0", "5,4,6", "100,99,1"])
    fun `수동으로 선택한 개수보다 적거나 많게 로또 번호를 선택할 수 없다`(total: Int, manual: Int, select: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Order.of(total, manual, LottoNumbersFixture.수동으로_선택된_로또번호_목록(select)) }
    }

    @ParameterizedTest
    @CsvSource(value = ["10,5", "99,98", "1,0"])
    fun `구매한 로또 개수의 총합은 수동과 자동으로 선택한 개수의 합과 같다`(total: Int, manual: Int) {
        // given
        val order = Order.of(total, manual, LottoNumbersFixture.수동으로_선택된_로또번호_목록(manual))

        // when
        val expect = order.total()

        // then
        assertThat(expect).isEqualTo(total)
    }
}
