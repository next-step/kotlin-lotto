package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPriceTest {
    @Test
    fun `상금을 주는 리스트를 생성한다`() {
        assertThat(LottoPrice.rankOf())
            .contains(
                LottoPrice.ALL_MATCHED,
                LottoPrice.FIVE_MATCHED_WITH_BONUS,
                LottoPrice.FIVE_MATCHED,
                LottoPrice.FOUR_MATCHED,
                LottoPrice.THREE_MATCHED
            )
    }

    @Test
    fun `일치하는 숫자의 개수에 따라 상금을 반환한다`() {
        assertThat(LottoPrice.from(0)).isEqualTo(LottoPrice.NOT_MATCHED)
        assertThat(LottoPrice.from(1)).isEqualTo(LottoPrice.ONE_MATCHED)
        assertThat(LottoPrice.from(2)).isEqualTo(LottoPrice.TWO_MATCHED)
        assertThat(LottoPrice.from(3)).isEqualTo(LottoPrice.THREE_MATCHED)
        assertThat(LottoPrice.from(4)).isEqualTo(LottoPrice.FOUR_MATCHED)
        assertThat(LottoPrice.from(5)).isIn(LottoPrice.FIVE_MATCHED, LottoPrice.FIVE_MATCHED_WITH_BONUS)
        assertThat(LottoPrice.from(6)).isEqualTo(LottoPrice.ALL_MATCHED)
    }
}
