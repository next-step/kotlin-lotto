package calcuator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class TokenizeUtilTest : StringSpec({
    "구분자를 쉼표(,) 이외에 콜론(:)을 구분자로 사용 된다." {
        forAll(
            row("1,2:3", listOf("1", "2", "3")),
            row("1,2:3,4", listOf("1", "2", "3", "4")),
        ) { text, expect ->
            TokenizeUtil.tokenizes(text) shouldBe expect
        }
    }

    "//와 \\n 문자 사이에 커스텀 구분자로 사용된다." {
        forAll(
            row("//;\n1;2;3", listOf("1", "2", "3")),
            row("//@\n2@2@2", listOf("2", "2", "2")),
        ) { text, expect ->
            TokenizeUtil.tokenizes(text) shouldBe expect
        }
    }
})
