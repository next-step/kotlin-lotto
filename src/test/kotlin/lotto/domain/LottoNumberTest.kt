package lotto.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `같은 로또 번호가 동일한 객체로 반환한다`() {
        val lotto1 = LottoNumber.from(1)
        val lotto2 = LottoNumber.from(1)
        lotto1 shouldBe lotto2
        lotto1 shouldBeSameInstanceAs lotto2
    }
}
