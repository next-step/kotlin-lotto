package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import lotto.domain.WinningNumbers

class WinningNumbersTest : FunSpec({
    test("당첨 번호를 저장할 수 있다.") {
        // given
        val size = 6
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val actual = WinningNumbers(numbers).numbers

        // then
        actual shouldHaveSize WinningNumbers.SIZE
    }
})
