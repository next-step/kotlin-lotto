package lotto.enums

import lotto.domain.enums.PrizeType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTypeTest {

    @ParameterizedTest
    @ValueSource(strings = ["3", "4", "5", "6"])
    fun `지난 주 로또 번호와 일치한 개수가 당첨 목록 있는지 확인합니다 존재하면 그 당첨 순위가 리턴 됩니다`(match: Int) {
        assertThat(PrizeType.containsMatch(match)).isEqualTo(match)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun `지난 주 로또 번호와 일치한 개수가 당첨 목록에 없으면 0을 반환 하는지 확인합니다`(match: Int) {
        assertThat(PrizeType.containsMatch(match)).isZero
    }
}
