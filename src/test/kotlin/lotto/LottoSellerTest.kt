package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoSeller
import lotto.domain.Money
import lotto.domain.OrderSheet
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoSellerTest {

    @Test
    fun `구매개수 만큼 로또를 발급한다`() {
        val order = OrderSheet.Valid(11, 0, Money(0))
        val lotto = LottoSeller.take(order) { List(it) { LottoNumbers() } }
        val expected = 11
        Assertions.assertThat(lotto.size).isEqualTo(expected)
    }

    @Test
    fun `사용자가 입력한 수동 번호의 로또 발급한다`() {
        val numbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val order = OrderSheet.Valid(0, 1, Money(1000))
        val lotto = LottoSeller.take(order) { List(it) { LottoNumbers(1, 2, 3, 4, 5, 6) } }

        val expected = 6

        lotto.forEach {
            Assertions.assertThat(it.matchCount(numbers)).isEqualTo(expected)
        }
    }

    private fun LottoNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
}
