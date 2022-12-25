package lotto.domain.model

import io.kotest.matchers.collections.shouldContainInOrder
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinningTest {

    @DisplayName("입력 된 당첨 번호로 당첨 번호가 생성되어야 한다")
    @Test
    fun winningNumbers() {
        val winning = Winning(Winning.makeLottoNumbers("1,2,3,4,5,6"), LottoNumber(1))

        winning.numbers.map { it.number } shouldContainInOrder listOf(1, 2, 3, 4, 5, 6)
    }

    @DisplayName("잘못 입력 된 당첨 번호로 당첨 번호가 생성되지 않는다")
    @ParameterizedTest
    @ValueSource(strings = ["", "a,b,c", "1,2,3", "1,2,3,4,5,6,7"])
    fun wrongWinningNumbers(input: String) {
        assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                Winning(winningNumbers = Winning.makeLottoNumbers(input), LottoNumber(1))
            }
    }
}
