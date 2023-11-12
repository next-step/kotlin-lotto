package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 6개의 번호를 가진다`() {
        val lotto = Lotto()
        lotto.numbers.size shouldBe 6
    }

    @Test
    fun `로또 번호는 서로 다른 숫자로 이루어져있다`() {
        val lotto = Lotto()
        lotto.numbers.distinct().size shouldBe 6
    }
}
