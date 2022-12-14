package lotto.service

import io.kotest.matchers.collections.shouldContainExactly
import lotto.model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoGeneratorTest {
    @Test
    internal fun `당첨번호는 숫자를 콤마(,)로 구분한 문자열을 받는다`() {
        val numbers = LottoGenerator.fromString("1,2,3,4,5,6")
        val expected = Lotto.of(1, 2, 3, 4, 5, 6)
        numbers shouldContainExactly expected
    }

    @Test
    internal fun `숫자가 아닌 값이 들어오면 RuntimeException`() {
        assertThrows<IllegalArgumentException> { LottoGenerator.fromString("1,$,3,4,5,6") }
    }
}
