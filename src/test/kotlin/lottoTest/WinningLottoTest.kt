package lottoTest

import lotto.domain.Lotto
import lotto.domain.WinningLotto
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("generateFailureWinningLottoArguments")

    fun `로또 번호와 보너스 번호는 중복될 수 없음`(lotto: Lotto, bonusNumber: Int) {
        assertThatThrownBy {
            WinningLotto(lotto, bonusNumber)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Duplicated number is in !")
    }

    companion object {
        @JvmStatic
        fun generateFailureWinningLottoArguments() = listOf(
            Arguments.of(
                Lotto(
                    listOf(1, 2, 3, 4, 5, 6)
                ),
                6
            ),
        )
    }
}
