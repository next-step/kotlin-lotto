package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoCountTest {

    @Test
    @DisplayName("수동과 자동 로또 개수의 범위 확인")
    fun `check lotto count validation`() {
        val price = Price(5000)
        val manualCount = 4

        val manualLottoCount = LottoCount(price.lottoCount).createLottoNumber(manualCount)
        val autoLottoCount = LottoCount(price.lottoCount - manualCount).createLottoNumber()

        Assertions.assertThat(manualLottoCount).isLessThanOrEqualTo(price.lottoCount)
        Assertions.assertThat(autoLottoCount).isLessThanOrEqualTo(price.lottoCount - manualLottoCount)
    }

    @Test
    @DisplayName("로또 생성 개수가 음수인 경우 0을 반환하는 상황")
    fun `check when lotto count less than zero`() {
        val price = Price(5000)
        val manualCount = 7
        val expectedAutoCount = 0

        val manualLottoCount = LottoCount(price.lottoCount).createLottoNumber(manualCount)
        val autoLottoCount = LottoCount(price.lottoCount - manualCount).createLottoNumber()

        Assertions.assertThat(manualLottoCount).isLessThanOrEqualTo(price.lottoCount)
        Assertions.assertThat(autoLottoCount).isEqualTo(expectedAutoCount)
    }
}
