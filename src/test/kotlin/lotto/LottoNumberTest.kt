package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({
    "로또 번호는 1이상이면 생성 가능하다." {
        // Arrange:
        val value = 1

        // Act:
        val lottoNumber = LottoNumber.generate(value)

        // Assert:
        lottoNumber.value shouldBe value
    }

    "로또 번호는 45이하이면 생성 가능하다." {
        // Arrange:
        val value = 45

        // Act:
        val lottoNumber = LottoNumber.generate(value)

        // Assert:
        lottoNumber.value shouldBe value
    }

    "로또 번호는 0이하이면 생성 불가능하다." {
        // Arrange:
        val value = 0

        // Act:
        val exception = shouldThrow<IllegalArgumentException> {
            LottoNumber.generate(value)
        }

        // Assert:
        exception.message shouldBe "로또 번호는 1부터 45까지 가능합니다. input = $value"
    }

    "로또 번호는 46이상이면 생성 불가능하다." {
        // Arrange:
        val value = 46

        // Act:
        val exception = shouldThrow<IllegalArgumentException> {
            LottoNumber.generate(value)
        }

        // Assert:
        exception.message shouldBe "로또 번호는 1부터 45까지 가능합니다. input = $value"
    }
})
