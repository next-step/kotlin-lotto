package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CountTest : StringSpec({

    "Count 객체를 생성할 수 있다" {
        // Arrange:
        val count = Count(1)

        // Act:
        val result = count

        // Assert:
        result shouldBe Count(1)
    }

    "Count 객체를 1 증가시킬 수 있다" {
        // Arrange:
        val count = Count(1)

        // Act:
        val result = count.plus()

        // Assert:
        result shouldBe Count(2)
    }

    "Count 객체는 음수를 입력하면 예외가 발생한다." {
        // Arrange:
        val value = -1

        // Act:
        val result = shouldThrow<IllegalArgumentException> {
            Count(-1)
        }.message

        // Assert:
        result shouldBe "음수는 입력할 수 없습니다. input = $value"
    }
})
