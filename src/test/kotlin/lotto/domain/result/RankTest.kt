package lotto.domain.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @ParameterizedTest
    @CsvSource(value = ["FIRST,2_000_000_000", "SECOND,1_500_000", "THIRD,50_000", "FOURTH,5_000", "NONE,0"])
    fun `당첨결과의 금액을 확인한다`(rank: Rank, amount: Long) {
        assertThat(rank.amount).isEqualTo(amount)
    }
}
