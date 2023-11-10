package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RecordTest {

    @ParameterizedTest
    @CsvSource(value = ["3|5000", "4|5000", "5|5000", "6|5000"], delimiter = '|')
    fun `일치하는 번호의 수, 당첨금액을 입력하여 등수정보 초기값을 반환한다`(
        matchCount: Int,
        reward: Int
    ) {
        val actual = Record.of(matchCount, reward)

        assertThat(actual.matchCount).isEqualTo(matchCount)
        assertThat(actual.reward).isEqualTo(reward)
        assertThat(actual.recordCount).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(value = ["1|5000", "2|5000", "0|5000", "-1|5000"], delimiter = '|')
    fun `일치하는 번호의 수가 3개 미만일때 에러를 반환한다`(
        matchCount: Int,
        reward: Int
    ) {
        assertThrows<IllegalArgumentException> {
            Record.of(matchCount, reward)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["3|-10", "4|-20", "5|-1000", "6|-100000", ], delimiter = '|')
    fun `등수 당첨금액이 0 미만일때 에러를 반환한다`(
        matchCount: Int,
        reward: Int
    ) {
        assertThrows<IllegalArgumentException> {
            Record.of(matchCount, reward)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["3|5000|13", "4|5000|10", "5|5000|5", "6|5000|1", ], delimiter = '|')
    fun `각 등수별 당첨로또의 당첨자가 생길때마다 당첨수을 반환한다`(
        matchCount: Int,
        reward: Int,
        count: Int,
    ) {
        val actual = Record.of(matchCount, reward)

        repeat(count) {
            actual.addCountByRecord(matchCount)
        }

        assertThat(actual.matchCount).isEqualTo(matchCount)
        assertThat(actual.reward).isEqualTo(reward)
        assertThat(actual.recordCount).isEqualTo(count)
    }
}
