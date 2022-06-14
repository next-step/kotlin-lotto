package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoSeller
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoSellerTest {

    @Test
    fun `구매금액만큼 로또를 발급한다`() {
        val lotto = LottoSeller.buy(Money(11500))
        val expected = 11
        Assertions.assertThat(lotto.size).isEqualTo(expected)
    }

    @Test
    fun `사용자가 입력한 수동 번호의 로또 발급한다`() {
        val numbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val lotto = LottoSeller.buy(Money(1000), listOf(numbers))

        val expected = 6

        lotto.forEach {
            Assertions.assertThat(it.matchCount(numbers)).isEqualTo(expected)
        }
    }

    @ParameterizedTest
    @CsvSource("1100, 1, true", "900, 1, false")
    fun `수동 구매에 필요한 금액보다 구매 금액이 작을 경우 실패를 알려준다`(money: Int, count: Int, expected: Boolean) {
        val result = LottoSeller.canPurchase(Money(money), count)

        Assertions.assertThat(result).isEqualTo(expected)
    }

    private fun LottoNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
}
