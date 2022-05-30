package lotto.agency

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoWinningTest {

    @Test
    fun `1등 - 6개 일치하고, 보너스 볼 일치하는 경우`() {
        Assertions.assertThat(LottoWinning.of(6, true)).isEqualTo(LottoWinning.FIRST_PLACE)
    }

    @Test
    fun `1등 - 6개 일치하고, 보너스 볼 일치하지 않는 경우`() {
        Assertions.assertThat(LottoWinning.of(6, false)).isEqualTo(LottoWinning.FIRST_PLACE)
    }

    @Test
    fun `2등 - 5개 일치하고, 보너스 볼 일치하는 경우`() {
        Assertions.assertThat(LottoWinning.of(5, true)).isEqualTo(LottoWinning.SECOND_PLACE)
    }

    @Test
    fun `3등 - 5개 일치하고, 보너스 볼 일치하지 않는 경우`() {
        Assertions.assertThat(LottoWinning.of(5, false)).isEqualTo(LottoWinning.THIRD_PLACE)
    }

    @Test
    fun `4등 - 4개 일치하고, 보너스 볼 일치하는 경우`() {
        Assertions.assertThat(LottoWinning.of(4, true)).isEqualTo(LottoWinning.FOURTH_PLACE)
    }

    @Test
    fun `4등 - 4개 일치하고, 보너스 볼 일치하지 않는 경우`() {
        Assertions.assertThat(LottoWinning.of(4, false)).isEqualTo(LottoWinning.FOURTH_PLACE)
    }

    @Test
    fun `5등 - 3개 일치하고, 보너스 볼 일치하는 경우`() {
        Assertions.assertThat(LottoWinning.of(3, true)).isEqualTo(LottoWinning.FIFTH_PLACE)
    }

    @Test
    fun `5등 - 3개 일치하고, 보너스 볼 일치하지 않는 경우`() {
        Assertions.assertThat(LottoWinning.of(3, false)).isEqualTo(LottoWinning.FIFTH_PLACE)
    }

    @Test
    fun `꽝 - 2개 일치하고, 보너스 볼 일치하는 경우`() {
        Assertions.assertThat(LottoWinning.of(2, true)).isEqualTo(LottoWinning.LOSE)
    }

    @Test
    fun `꽝 - 2개 일치하고, 보너스 볼 일치하지 않는 경우`() {
        Assertions.assertThat(LottoWinning.of(2, false)).isEqualTo(LottoWinning.LOSE)
    }

    @Test
    fun `꽝 - 1개 일치하고, 보너스 볼 일치하는 경우`() {
        Assertions.assertThat(LottoWinning.of(1, true)).isEqualTo(LottoWinning.LOSE)
    }

    @Test
    fun `꽝 - 1개 일치하고, 보너스 볼 일치하지 않는 경우`() {
        Assertions.assertThat(LottoWinning.of(1, false)).isEqualTo(LottoWinning.LOSE)
    }

    @Test
    fun `꽝 - 0개 일치하고, 보너스 볼 일치하는 경우`() {
        Assertions.assertThat(LottoWinning.of(0, true)).isEqualTo(LottoWinning.LOSE)
    }

    @Test
    fun `꽝 - 0개 일치하고, 보너스 볼 일치하지 않는 경우`() {
        Assertions.assertThat(LottoWinning.of(0, false)).isEqualTo(LottoWinning.LOSE)
    }
}
