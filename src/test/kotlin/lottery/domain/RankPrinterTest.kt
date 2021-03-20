package lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankPrinterTest {
    @ParameterizedTest
    @CsvSource
    (
        value = [
            "FIFTH/ 3개 일치",
            "FOURTH/ 4개 일치",
            "THIRD/ 5개 일치",
            "SECOND/ 5개 일치, 보너스 볼 일치",
            "FIRST/ 6개 일치"
        ],
        delimiter = '/'
    )
    fun `당첨 순위에 대한 내용을 출력한다`(rank: Rank, content: String) {
        val rankPrinter = RankPrinter.valueOf(rank)

        assertThat(rankPrinter.content).isEqualTo(content)
    }
}
