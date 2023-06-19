package lotto.domain.model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `1 ~ 45 사이의 값을 6개 가지고 있다`() {
        val lotto = Lotto()
        lotto.numbers.size shouldBe 6

        for (number in lotto.numbers) {
            (number in (1..45)) shouldBe true
        }
    }

    @Test
    fun `6개의 숫자는 중복되지 않는다`() {
        val lotto = Lotto()
        lotto.numbers.toSet().size shouldBe 6
    }
}
