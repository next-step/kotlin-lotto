package stringcalculator

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TokenSplitterTest : StringSpec({
    "콤마(,) 혹은 콜론(:)을 기준으로 값을 분리한 배열을 반환한다." {
        val commaExp = "1,2,3"
        val colonExp = "1:2:3"

        val commaTokens = TokenSplitter.splitExpBySeparator(commaExp)
        val colonTokens = TokenSplitter.splitExpBySeparator(colonExp)

        assertSoftly {
            commaTokens shouldBe listOf("1", "2", "3")
            colonTokens shouldBe listOf("1", "2", "3")
        }
    }

    "커스텀 구분자를 전달하면 해당 구분자를 기준으로 분리한 배열을 반환한다." {
        val exp = "//<\n1<2<3"

        val result = TokenSplitter.splitExpBySeparator(exp)

        result shouldBe listOf("1", "2", "3")
    }

    "전달된 커스텀 구분자의 형식이 올바르지 않으면 예외를 반환한다." {
        val exp1 = "//\n1,2,3"
        val exp2 = "//>1,2,3"

        assertSoftly {
            shouldThrow<RuntimeException> { TokenSplitter.splitExpBySeparator(exp1) }
            shouldThrow<RuntimeException> { TokenSplitter.splitExpBySeparator(exp2) }
        }
    }
})
