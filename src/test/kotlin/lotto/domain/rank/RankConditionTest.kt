package lotto.domain.rank

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RankConditionTest {

    @Test
    fun `보너스가 일치해야할 때 카운트가 일치하고 보너스가 일치하면 조건에 부합한다`() {
        val rankCondition = RankCondition(5, BonusCondition.NEED_MATCH)

        val match = rankCondition.match(5, true)

        match shouldBe true
    }

    @Test
    fun `보너스가 일치하지 않아야할 때 카운트가 일치하고 보너스가 일치하면 조건에 부합하지 않는다`() {
        val rankCondition = RankCondition(5, BonusCondition.NEED_NOT_MATCH)

        val match = rankCondition.match(5, true)

        match shouldBe false
    }

    @Test
    fun `보너스 일치 여부가 상관 없을 때 카운트가 일치하고 보너스가 일치하면 조건에 부합한다`() {
        val rankCondition = RankCondition(5, BonusCondition.NO_MATTER)

        val match = rankCondition.match(5, true)

        match shouldBe true
    }

    @Test
    fun `보너스 일치 여부가 상관 없을 때 카운트가 일치하고 보너스가 일치하지 않으면 조건에 부합한다`() {
        val rankCondition = RankCondition(5, BonusCondition.NO_MATTER)

        val match = rankCondition.match(5, false)

        match shouldBe true
    }
}
