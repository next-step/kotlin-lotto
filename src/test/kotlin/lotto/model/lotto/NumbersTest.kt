package lotto.model.lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumbersTest {

    @DisplayName(value = "Numbers,winnerNumbers 6개의 같은 숫자일 경우, MatchingCounts = 6")
    @Test
    fun checkNumbersMatchingCountCase6() {
        val winnerNumbers = Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers().shuffled())
        val numbers = Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers().shuffled())
        assertThat(numbers.getMatchingCounts(winnerNumbers)).isSameAs(6)
    }

    @DisplayName(value = "Numbers,winnerNumbers 0개의 같은 숫자일 경우, MatchingCounts = 0")
    @Test
    fun checkNumbersMatchingCountCase0() {
        val winnerNumbers = Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers().shuffled())
        val numbers = Numbers(listOf(11, 12, 13, 14, 15, 16).toLottoNumbers().shuffled())
        assertThat(numbers.getMatchingCounts(winnerNumbers)).isSameAs(0)
    }

    @DisplayName(value = "Numbers,winnerNumbers [5, 4, 3, 2, 1]개의 같은 숫자일 경우, MatchingCounts = [5, 4, 3, 2, 1]")
    @ParameterizedTest
    @ValueSource(ints = [5, 4, 3, 2, 1])
    fun checkNumbersMatchingCountCases(input: Int) {
        val original = listOf(1, 2, 3, 4, 5, 6)
        val winnerNumbers = Numbers(original.shuffled().toLottoNumbers())

        // input 되는 숫자만큼, winnerNum 입력 / 나머지는 not WinnerNum
        val matchingNumbers = mutableListOf<LottoNumber>().apply {
            addAll(original.take(input).toLottoNumbers())
            addAll(listOf(11, 12, 13, 14, 15, 16).shuffled().take(Lotto.NUMBER_COUNT - input).toLottoNumbers())
        }
        val numbers = Numbers(matchingNumbers)

        assertThat(numbers.getMatchingCounts(winnerNumbers)).isSameAs(input)
    }

    @DisplayName(value = "Numbers생성시, InteagerList의 사이즈가 Lotto.NUMBER_COUNT와 같아야한다, Exception")
    @Test
    fun inputNegativeAndNonInteger() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                "1,2,3,4,5,6,7,8".toNumbers()
            }
    }
}
