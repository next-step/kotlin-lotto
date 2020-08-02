package lotto.domain

import lotto.view.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @Test
    fun `생성한 로또 번호가 1-45 범위 안에 있는지 확인`() {
        assertThat(IntRange(1, 45).toList().containsAll(Lotto.of().numbers)).isTrue()
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "4, 4",
            "10,10"
        ]
    )
    fun `입력한 갯수 만큼 로또 번호 생성`(purchaseCount: Int, expected: Int) {
        assertThat(Lottos.of(purchaseCount).lottos.size).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,3,4,",
            "1,2,A,4,5"
        ]
    )
    fun `입력한 당첨번호가 데이터 포멧이 이상할 때 null을 반환하는지 확인`(numbers: String) {
        assertThat(InputView.validateWinningNumber(numbers)).isNull()
    }

    @ParameterizedTest
    @MethodSource("generateWinningTestData")
    fun `구입한 로또가 당첨번호와 몇개나 일치하는지 확인`(lotto: Lotto, expected: Int) {
        val winningNumber = listOf(2, 3, 22, 40, 45)

        lotto.countWinningNumber(winningNumber)
        assertEquals(lotto.winningCount, expected)
    }

    companion object {
        @JvmStatic
        fun generateWinningTestData(): List<Arguments> {
            return listOf(
                Arguments.of(Lotto(listOf(3, 10, 15, 22, 41, 44)), 2),
                Arguments.of(Lotto(listOf(1, 2, 12, 22, 40, 45)), 4)
            )
        }
    }
}
