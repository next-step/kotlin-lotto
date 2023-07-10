package lotto.util

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SplitterTest {

    @Test
    fun `쉼표로 구분된 문자열을 숫자 리스트로 변환한다`() {
        val input = "1, 2, 3, 4, 5, 6"
        val splitter = Splitter()

        val numbers = splitter.toNumbers(input)

        numbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }
}
