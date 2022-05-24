package lotto

import lotto.LottoCreator.issue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCreatorTest {

    @Test
    fun `로또를 설정한 횟수에 맞게 랜덤하게 발급한다`() {
        val count = 3
        assertThat(issue(count).size).isEqualTo(count)
    }
}