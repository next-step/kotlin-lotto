package lotto

import lotto.domain.Grade
import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LottoListTest {

    data class TestCase(val numbers: List<Int>, val expectedGrade: Grade)

    @ParameterizedTest
    @ArgumentsSource(TestCases::class)
    fun `전체 로또의 결과 정보를 리턴한다`(testCase: TestCase) {
        val lottoNumbers = LottoNumbers(testCase.numbers)
        val lottoList = LottoList(listOf(lottoNumbers), Money(0))

        val winningNumbers = WinningNumbers(1, 2, 3, 4, 5, 6)

        val result = lottoList.match(winningNumbers, LottoNumber(7))

        Assertions.assertThat(result.getMatchedCount(testCase.expectedGrade)).isEqualTo(1)
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

    private fun LottoNumbers(numbers: List<Int>) = LottoNumbers(numbers.map(::LottoNumber))
    private fun WinningNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
}
