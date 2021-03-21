package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPriceTest {
    @ParameterizedTest
    @ValueSource(ints = [500, 10, 0, 50, 100, 99, 999])
    fun `최소금액 1000원 만족 못할시 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPrice(0)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "10000, 5, true",
        "50000, 50, true",
        "999999, 999, true",
        "1000, 2, false"
    )
    fun `금액이 카운트단위보다 크거나 같은 경우 참`(price: Int, count: Int, expected: Boolean) {
        val lottoPrice = LottoPrice(price)
        assertThat(lottoPrice.isGreaterThanEqualsByCount(count)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "10000, 5, 5",
        "50000, 50, 0",
        "300000, 20, 280"
    )
    fun `로또금액은 수동로또갯수를 받아 자동로또갯수를 반환한다`(price: Int, manualLottoCount: Int, expectedAutomaticLottoCount: Int) {
        val lottoPrice = LottoPrice(price)
        assertThat(lottoPrice.calculateAutomaticCount(manualLottoCount)).isEqualTo(expectedAutomaticLottoCount)
    }
}
