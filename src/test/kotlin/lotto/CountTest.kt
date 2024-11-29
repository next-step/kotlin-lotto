package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CountTest : StringSpec ({

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

})