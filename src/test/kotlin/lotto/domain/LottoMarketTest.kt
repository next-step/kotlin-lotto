package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMarketTest {
    @ParameterizedTest
    @CsvSource(value = ["14000,14", "14500,14", "1000, 1", "500, 0"])
    fun `마켓에서 금액만큼 로또를 살 수 있다`(price: Int, expect: Int) {
        assertThat(LottoMarket.buy(price, emptyList()).tickets.size).isEqualTo(expect)
    }

    @Test
    fun `수동으로 구매한 번호는 구매한 로또 티켓에 포함되어 있다`() {
        val lottoNumbers = LottoMarket.buy(1000, listOf("1,2,3,4,5,6")).tickets[0].lottoNumbers.map { it.number }
        assertThat(lottoNumbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}
