package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import java.lang.RuntimeException

class PositiveNumberTest : StringSpec({
    "음수가 값으로 들어오면 RuntimeException 을 반환한다." {
        val negativeNumber = -100
        val exception = shouldThrow<RuntimeException> {
            PositiveNumber(negativeNumber)
        }
        exception.message should startWith("숫자는 음수일 수 없습니다.")
    }
})
