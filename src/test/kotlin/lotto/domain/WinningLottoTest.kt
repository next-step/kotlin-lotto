package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningLottoTest {

    @Test
    fun `,로 분리되는 6개의 숫자가 있는 문자열과 숫자 문자를 입력하면 생성된다`() {
        assertThat(WinningLotto.byInput("1, 2, 3, 4, 5, 6", "7")).isEqualTo(WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7))
    }

    @Test
    fun `로또 번호와 겹치는 보너스 번호를 입력할 경우 에러를 반환한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `고유한 6개의 숫자가 있는 배열과 그것과 겹치지 않는 보너스 번호를 입력하면 생성된다`() {
        assertThat(WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)).isExactlyInstanceOf(WinningLotto::class.java)
    }

    @Test
    fun `전부(6개) 같으면 Rank FIRST 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(
            winNumber.compareWith(
                Lotto(
                    setOf(
                        LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)
                    )
                ),
            )
        ).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `5개가 같으면 Rank SECOND 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(
            winNumber.compareWith(
                Lotto(
                    setOf(
                        LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(7)
                    )
                ),
            )
        ).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `4개가 같으면 Rank THIRD 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(
            winNumber.compareWith(
                Lotto(
                    setOf(
                        LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(7), LottoNumber(8)
                    )
                ),
            ),
        ).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `3개가 같으면 Rank FOURTH 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(
            winNumber.compareWith(
                Lotto(
                    setOf(
                        LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(7), LottoNumber(8), LottoNumber(9)
                    )
                ),
            )
        ).isEqualTo(Rank.FOURTH)
    }

    @DisplayName("로또 비교 테스트")
    @ParameterizedTest(name = "2장 이하가 같으면 NotWin을 반환한다")
    @MethodSource("valueSource")
    fun `2장 이하가 같으면 MISS 반환한다`(lotto: Lotto) {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(winNumber.compareWith(lotto)).isEqualTo(Rank.MISS)
    }

    companion object {
        @JvmStatic
        fun valueSource(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Lotto(
                        setOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(7),
                            LottoNumber(8),
                            LottoNumber(9),
                            LottoNumber(10)
                        )
                    )
                ),
                Arguments.of(
                    Lotto(
                        setOf(
                            LottoNumber(1),
                            LottoNumber(7),
                            LottoNumber(8),
                            LottoNumber(9),
                            LottoNumber(10),
                            LottoNumber(11),
                        )
                    )
                ),
                Arguments.of(
                    Lotto(
                        setOf(
                            LottoNumber(7),
                            LottoNumber(8),
                            LottoNumber(9),
                            LottoNumber(10),
                            LottoNumber(11),
                            LottoNumber(12),
                        )
                    )
                ),
            )
        }
    }
}
