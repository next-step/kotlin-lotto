package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CheckerTest {
    @CsvSource(
        value = [
            "'1,2,3,4,5,6', '1,2,3,4,5,6', 6",
            "'1,2,3,4,5,7', '1,2,3,4,5,6', 5",
            "'1,2,3,4,8,7', '1,2,3,4,5,6', 4",
            "'1,2,3,9,8,7', '1,2,3,4,5,6', 3",
            "'1,2,10,9,8,7', '1,2,3,4,5,6', 2",
            "'1,11,10,9,8,7', '1,2,3,4,5,6', 1",
            "'12,11,10,9,8,7', '1,2,3,4,5,6', 0",
        ]
    )
    @ParameterizedTest
    fun `지난당첨번호와 일치하는 개수를 확인한다`(lottoNumberText: String, lastNumberText: String, matchCount: Int) {
        val lastNumber = lastNumberText.split(",").map { LottoNumber(it.toInt()) }
        val checker = Checker(lastNumber)
        val numbers = lottoNumberText.split(",").map { LottoNumber(it.toInt()) }
        assertThat(checker.match(numbers)).isEqualTo(matchCount)
    }
}
