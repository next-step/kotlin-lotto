package lotto

import lotto.domain.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PrizeTest {
    @DisplayName("getPrize 확인하기")
    @Test
    fun validatePrize() {
        assertThat(Prize.getPrize(4))
            .isEqualTo(Prize.MATCH_FOUR)
    }
}
