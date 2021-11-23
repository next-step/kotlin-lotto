package lotto.enums

import lotto.domain.enums.PrizeType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTypeTest {

    @ParameterizedTest
    @ValueSource(strings = ["3", "4", "5", "6"])
    fun `지난 주 로또 번호와 일치한 개수가 당첨 목록 있는지 확인합니다`(match: Int) {
        assertThat(PrizeType.containsMatch(match)).isEqualTo(match)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun `지난 주 로또 번호와 일치한 개수가 당첨 목록에 없으면 0을 반환 하는지 확인합니다`(match: Int) {
        assertThat(PrizeType.containsMatch(match)).isZero
    }

    @Test
    fun `3개가 당첨될경우 3개의 당첨금액인 5,000원이 반환되는지 확인합니다`() {
        assertThat(PrizeType.findPrizeMoney(3)).isEqualTo(PrizeType.THREE.money)
    }

    @Test
    fun `4개가 당첨될경우 4개의 당첨금액인 50,000원이 반한되는지 확인합니다`() {
        assertThat(PrizeType.findPrizeMoney(4)).isEqualTo(PrizeType.FOUR.money)
    }

    @Test
    fun `5개가 당첨될 경우 5개의 당첨금액인 1,500,000원이 반환되는지 확인합니다`() {
        assertThat(PrizeType.findPrizeMoney(5)).isEqualTo(PrizeType.FIVE.money)
    }

    @Test
    fun `6개가 당첨될 경우 6개의 당첨금액인 2,000,000,000원이 반환되는지 확인합니다`() {
        assertThat(PrizeType.findPrizeMoney(6)).isEqualTo(PrizeType.SIX.money)
    }
}
