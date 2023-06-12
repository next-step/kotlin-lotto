import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositiveTest : StringSpec({

    "덧셈" {
        Positive(1).add(Positive(2)) shouldBe Positive(3)
    }

    "Positive 생성시 음수를 받으면 예외 반환" {
        shouldThrow<IllegalArgumentException> { Positive(-1) }
    }
})
