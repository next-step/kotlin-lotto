package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinNumbersTest : StringSpec({
    "당첨 번호는 6개의 숫자로 구성된다." {
        val winNumbers = WinNumbers(setOf(1, 2, 3, 4, 5, 6))

        winNumbers.numbers.size shouldBe 6
    }

    "당첨 번호 생성 시 6개 미만 혹은 6개 초과된 숫자가 전달될 경우 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> { WinNumbers(setOf()) }
            shouldThrow<IllegalArgumentException> { WinNumbers(setOf(1, 2, 3, 4, 5)) }
            shouldThrow<IllegalArgumentException> { WinNumbers(setOf(1, 2, 3, 4, 5, 6, 7)) }
        }
    }

    "당첨 번호 생성 시 1 ~ 45를 벗어난 숫자들이 전달될 경우 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> { WinNumbers(setOf(1, 2, 3, 4, 5, 46)) }
            shouldThrow<IllegalArgumentException> { WinNumbers(setOf(0, 2, 3, 4, 5, 6)) }
        }
    }

    "당첨 번호는 전달받은 로또 중 몇개의 값이 일치하는지 계산할 수 있다." {
        val winNumbers = WinNumbers(setOf(1, 2, 3, 4, 5, 6))

        val result = winNumbers.countMatchingNumbers(setOf(1, 2, 7, 8, 9, 10))

        result shouldBe 2
    }
})
