package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BounsBallTest {
    @Test
    fun `보너스 넘버는 숫자 한개를 가진다`() {
        val bounsBall = BounsBall(1)

        assertThat(bounsBall.bounsNumber).isEqualTo(1)
    }
}
