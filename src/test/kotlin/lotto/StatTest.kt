package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StatTest {
    @CsvSource(
        value = [
            "'1,2,3,4,5,6|1,2,3,11,22,7|5,6,7,8,9,10', '1,2,3,11,22,33', '3|5|0'"
        ]
    )
    @ParameterizedTest
    fun `로또번호들의 일치하는 번호개수를 확인한다`(numberList: String, lastNumber: String, matchCount: String) {

        val lottoNumbers = numberList.split("|")
        val matchCounts = matchCount.split("|")
        val lottos: List<Lotto> = lottoNumbers.map { number -> Lotto { this.generateNumbers(number.trim()) } }
        val stats = Stat(lottos, Checker(lastNumber)).matchResult()
        stats.forEachIndexed { index, record: MatchState ->
            assertThat(record.matchCount).isEqualTo(matchCounts[index].trim().toInt())
        }
    }

    private fun generateNumbers(text: String): List<Int> {
        return text.split(",").map { it.toInt() }
    }
}
