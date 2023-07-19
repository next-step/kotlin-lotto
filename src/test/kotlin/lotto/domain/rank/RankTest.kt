package lotto.domain.rank

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {

    @ParameterizedTest
    @CsvSource(value = ["3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST"])
    fun `당첨 개수와 보너스 당첨 여부를 받아 등수를 반환한다`(count: Int, matchBonus: Boolean, expected: Rank) {
        val rank = Rank.from(count, matchBonus)

        rank shouldBe expected
    }
}
