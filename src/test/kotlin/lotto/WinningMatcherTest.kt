package lotto

import lotto.domain.Grade
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningMatcher
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class WinningMatcherTest {

    data class TestCase(val numbers: List<Int>, val expected: Grade)

    @Test
    fun `당첨번호와 보너스 번호가 중복될 경우 IllegalArgumentException 예외를 리턴한다`() {
        assertThrows<IllegalArgumentException> {
            val winningNumbers = WinningNumbers(1, 2, 3, 4, 5, 6)
            WinningMatcher(winningNumbers, LottoNumber(6))
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestCases::class)
    fun `당첨번호와 같은 번호의 개수에 따라 등수를 리턴한다`(testCase: TestCase) {
        val winningNumbers = WinningNumbers(1, 2, 3, 4, 5, 6)
        val matcher = WinningMatcher(winningNumbers, LottoNumber(7))

        val lotto = LottoNumbers(testCase.numbers)

        Assertions.assertThat(matcher.getMatchGrade(lotto)).isEqualTo(testCase.expected)
    }

    private class TestCases : ArgumentsProvider by ArgumentsProvider({
        val testCases = listOf(
            TestCase(listOf(1, 2, 3, 4, 5, 6), Grade.First),
            TestCase(listOf(1, 2, 3, 4, 5, 7), Grade.Second),
            TestCase(listOf(1, 2, 3, 4, 5, 11), Grade.Third),
            TestCase(listOf(1, 2, 3, 4, 11, 12), Grade.Fourth),
            TestCase(listOf(1, 2, 3, 11, 12, 13), Grade.Five)
        )

        Stream.of(*testCases.toTypedArray()).map { Arguments.of(it) }
    })

    private fun WinningNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
    private fun LottoNumbers(numbers: List<Int>) = LottoNumbers(numbers.map(::LottoNumber))
}
