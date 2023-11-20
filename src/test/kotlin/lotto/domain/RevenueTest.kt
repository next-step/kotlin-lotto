package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RevenueTest {

    @Test
    fun `일치하는 로또 번호 갯수와 보너스 번호 일치 여부를 통해 등수를 찾는다`() {
        val revenue = Revenue.of(5, false)
        revenue shouldBe Revenue.THIRD
    }
}
