package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ManualLottoCountTest {

    @Test
    fun `수동 로또의 수가 초과된 경우 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            ManualLottoCount(count = 5, price = 4000)
        }
    }

    @Test
    fun `자동로또 구매가능 개수 계산에 성공한다`() {
        // given
        val manualLottoCount = ManualLottoCount(count = 2, price = 4000)

        // expect
        assertThat(manualLottoCount.availableAutoCount).isEqualTo(2)
    }
}
