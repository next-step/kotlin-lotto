package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningLottoTest {

    @Test
    fun `,로 분리되는 6개의 숫자가 있는 문자열을 입력하면 생성된다`() {
        assertThat(WinningLotto.byInput("1, 2, 3, 4, 5, 6")).isEqualTo(WinningLotto(listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `고유한 6개의 숫자가 있는 배열을 입력하면 생성된다`() {
        assertThat(WinningLotto(listOf(1, 2, 3, 4, 5, 6))).isExactlyInstanceOf(WinningLotto::class.java)
    }

    @Test
    fun `전부(6개) 같으면 CompareResult FirstWin을 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winNumber.compareWith(Lotto(listOf(1, 2, 3, 4, 5, 6)))).isEqualTo(LottoResult.FirstWin)
    }

    @Test
    fun `5개가 같으면 CompareResult SecondWin 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winNumber.compareWith(Lotto(listOf(1, 2, 3, 4, 5, 7)))).isEqualTo(LottoResult.SecondWin)
    }

    @Test
    fun `4개가 같으면 CompareResult SecondWin 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winNumber.compareWith(Lotto(listOf(1, 2, 3, 4, 7, 8)))).isEqualTo(LottoResult.ThirdWin)
    }

    @Test
    fun `3개가 같으면 CompareResult SecondWin 반환한다`() {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winNumber.compareWith(Lotto(listOf(1, 2, 3, 7, 8, 9)))).isEqualTo(LottoResult.FourthWin)
    }

    @DisplayName("로또 비교 테스트")
    @ParameterizedTest(name = "2장 이하가 같으면 NotWin을 반환한다")
    @MethodSource("valueSource")
    fun `2장 이하가 같으면 NotWin을 반환한다`(lotto: Lotto) {
        val winNumber = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winNumber.compareWith(lotto)).isEqualTo(LottoResult.NotWin)
    }

    companion object {
        @JvmStatic
        fun valueSource(): List<Arguments> {
            return listOf(
                Arguments.of(Lotto(listOf(1, 2, 7, 8, 9, 10))),
                Arguments.of(Lotto(listOf(1, 7, 8, 9, 10, 11))),
                Arguments.of(Lotto(listOf(7, 8, 9, 10, 11, 12))),
            )
        }
    }
}
