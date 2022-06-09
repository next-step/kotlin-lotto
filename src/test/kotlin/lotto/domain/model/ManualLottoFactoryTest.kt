package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ManualLottoFactoryTest {
    @Test
    fun `ManualLottoFactory는 숫자를 직접 입력받아 그 숫자들로 Lotto를 만든다`() {
        val manualLottoFactory = ManualLottoFactory(listOf(1, 2, 3, 4, 5, 6))

        val expected = Lotto.from(1, 2, 3, 4, 5, 6)

        assertThat(manualLottoFactory.create().numbers).isEqualTo(expected.numbers)
    }
}
