package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class LottoTest {
    @RepeatedTest(5)
    fun `1~45 범위의 랜덤 숫자 6개를 생성한다`() {
        assertThat(Lotto().numbers.size).isEqualTo(6)
    }
}
