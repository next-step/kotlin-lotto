package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class AwardResultTest {

    @Test
    fun `로또 결과 합계가 반환된다`() {
        // given
        val awardResult = AwardResult(Award.FOURTH_PLACE, 3)

        // when, then
        assertThat(awardResult.sumOfPrize).isEqualTo(150_000)
    }
}
