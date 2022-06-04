package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
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

    @ParameterizedTest
    @MethodSource("evaluateTest")
    fun `로또 평가해서 당첨 리스트로 리턴`(lottoList: List<Lotto>, winnings: List<Winning>) {
        val winningLotto = WinningLotto(Lotto(setOf(1, 2, 3, 4, 5, 6)), 7)
        val lottos = Lottos(lottoList)

        assertThat(winningLotto.evaluate(lottos)).isEqualTo(winnings)
    }

    companion object {
        @JvmStatic
        private fun evaluateTest(): List<Arguments> {
            return listOf(
                Arguments.of(
                    listOf(
                        Lotto(setOf(1, 2, 3, 4, 5, 6)),
                        Lotto(setOf(1, 2, 3, 4, 5, 10)),
                        Lotto(setOf(1, 2, 6, 4, 5, 7)),
                    ),
                    listOf(
                        Winning.FIRST,
                        Winning.THIRD,
                        Winning.SECOND
                    )
                ),
                Arguments.of(
                    listOf(
                        Lotto(setOf(11, 21, 31, 14, 15, 6)),
                        Lotto(setOf(1, 2, 3, 14, 15, 7)),
                    ),
                    listOf(
                        Winning.FAIL,
                        Winning.FIFTH
                    )
                )
            )
        }
    }
}
