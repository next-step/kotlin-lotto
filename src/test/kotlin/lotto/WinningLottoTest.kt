package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `당첨번호와 보너스 번호가 중복되면 RuntimeException 발생`(bonusNumber: Int) {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        assertThatIllegalArgumentException().isThrownBy {
            WinningLotto(lotto, bonusNumber)
        }
    }
}
