package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumbersTest {

    @DisplayName(value = "Numbers,winnerNumbers 6개의 같은 숫자일 경우, MatchingCounts = 6")
    @Test
    fun checkNumbersMatchingCountCase6() {
        val winnerNumbers = Numbers(listOf(1, 2, 3, 4, 5, 6).shuffled())
        val numbers = Numbers(listOf(1, 2, 3, 4, 5, 6).shuffled())
        Assertions.assertThat(numbers.getMatchingCounts(winnerNumbers)).isSameAs(6)
    }

    @DisplayName(value = "Numbers,winnerNumbers 0개의 같은 숫자일 경우, MatchingCounts = 0")
    @Test
    fun checkNumbersMatchingCountCase0() {
        val winnerNumbers = Numbers(listOf(1, 2, 3, 4, 5, 6).shuffled())
        val numbers = Numbers(listOf(11, 12, 13, 14, 15, 16).shuffled())
        Assertions.assertThat(numbers.getMatchingCounts(winnerNumbers)).isSameAs(0)
    }

    @DisplayName(value = "Numbers,winnerNumbers [5, 4, 3, 2, 1]개의 같은 숫자일 경우, MatchingCounts = [5, 4, 3, 2, 1]")
    @ParameterizedTest
    @ValueSource(ints = [5, 4, 3, 2, 1])
    fun checkNumbersMatchingCountCases(input: Int) {
        val original = listOf(1, 2, 3, 4, 5, 6)
        val winnerNumbers = Numbers(original.shuffled())

        //input 되는 숫자만큼, winnerNum 입력 / 나머지는 not WinnerNum
        val matchingNumbers = mutableListOf<Int>().apply {
            addAll(original.take(input))
            addAll(listOf(11, 12, 13, 14, 15, 16).shuffled().take(Lotto.NUMBER_COUNT - input))
        }
        val numbers = Numbers(matchingNumbers)

        Assertions.assertThat(numbers.getMatchingCounts(winnerNumbers)).isSameAs(input)
    }

    @DisplayName(value = "Numbers생성시, InteagerList의 사이즈가 Lotto.NUMBER_COUNT와 같아야한다, Exception")
    @Test
    fun inputNegativeAndNonInteger() {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                "1,2,3,4,5,6,7,8".toNumbers()
            }
    }

    @DisplayName(value = "보너스 볼은, 당첨번호와 중복되거나, 로또 숫자 범위를 넘어가서는 안된다, Exception")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 0, 55])
    fun isValidateBonusNumberTest(input: Int) {
        val winnerNumber = "1,2,3,4,5,6".toNumbers()

        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                winnerNumber.isValidateBonusNumber(input)
            }
    }
}
