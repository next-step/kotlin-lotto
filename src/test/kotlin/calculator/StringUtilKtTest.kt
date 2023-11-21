package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringUtilKtTest : FunSpec({

    context("StringUtil") {

        test("숫자 형식의 문자열을 숫자로 반환한다. (양의 숫자)") {
            "3".toPositiveLong() shouldBe 3L
        }

        test("음수일 경우 RuntimeException 예외 처리를 한다.") {
            shouldThrow<RuntimeException> {
                "-4".toPositiveLong()
            }
        }

        test("숫자형태가 아닐 경우 RuntimeException 예외 처리를 한다.") {
            shouldThrow<RuntimeException> {
                "aa".toPositiveLong()
            }
        }
    }
})
