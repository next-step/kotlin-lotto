package lotto.enums

import lotto.domain.enums.PrizeType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTypeTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2"])
    fun `3개 미만이 당첨될경우 나머지 PrizeType이 반환되는지 확인합니다`(match: Int) {
        assertThat(PrizeType.findPrize(match, false)).isEqualTo(PrizeType.OTHER_PLACE)
    }

    @Test
    fun `3개가 당첨될경우 5등의 PrizeType이 반환되는지 확인합니다`() {
        assertThat(PrizeType.findPrize(3, false)).isEqualTo(PrizeType.FIFTH_PLACE)
    }

    @Test
    fun `4개가 당첨될경우 4등의 PrizeType이 반한되는지 확인합니다`() {
        assertThat(PrizeType.findPrize(4, false)).isEqualTo(PrizeType.FOURTH_PLACE)
    }

    @Test
    fun `5개가 당첨되고 보너스번호 미포함일 경우 3등의 PrizeType이 반환되는지 확인합니다`() {
        assertThat(PrizeType.findPrize(5, false)).isEqualTo(PrizeType.THIRD_PLACE)
    }

    @Test
    fun `5개가 당첨되고 보너스번호 포함일 경우 2등의 PrizeType이 반환되는지 확인합니다`() {
        assertThat(PrizeType.findPrize(5, true)).isEqualTo(PrizeType.SECOND_PLACE)
    }

    @Test
    fun `6개가 당첨될 경우 1등의 PrizeType이 반환되는지 확인합니다`() {
        assertThat(PrizeType.findPrize(6, false)).isEqualTo(PrizeType.FIRST_PLACE)
    }

    @Test
    fun `보너스 당첨번호 당첨이 되었을때 2등의 PrizeType이 반환되는지 확인합니다`() {
        assertThat(PrizeType.isBonus(true)).isEqualTo(PrizeType.SECOND_PLACE)
    }

    @Test
    fun `보너스 당첨번호 당첨이 안되었을 경우 3등의 PrizeType이 반환되는지 확인합니다()`() {
        assertThat(PrizeType.isBonus(false)).isEqualTo(PrizeType.THIRD_PLACE)
    }

}
