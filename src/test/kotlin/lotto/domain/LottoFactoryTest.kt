package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class LottoFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1000, 2000, 2200, 3000, 3500, 4000, 5000, 5500])
    fun `로또를 구매하면 1000원 단위로 구매한다`(money: Int) {
        // given
        val expected = money / Lotto.LOTTO_PRICE
        val manualLottoCount = 0

        // when
        val lottoCount = LottoFactory.calculateLottoCount(money, manualLottoCount)

        // then
        assertThat(lottoCount.autoLottoCount).isEqualTo(expected)
    }

    @Test
    fun `수동으로 구매할 로또 수가 전체 로또 수보다 많으면 예외를 발생한다`() {
        // given
        val money = 1500
        val manualLottoCount = 2

        // when, then
        assertThrows<IllegalArgumentException> { LottoFactory.calculateLottoCount(money, manualLottoCount) }
    }
}
