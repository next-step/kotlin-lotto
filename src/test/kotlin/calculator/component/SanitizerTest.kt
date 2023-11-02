package calculator.component

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SanitizerTest : StringSpec({
    "빈 문자열 을 입력하는 경우 빈 문자열 을 반환해야한다" {
        val actual = Sanitizer.sanitize("")
        actual shouldBe ""
    }

    "null을 입력할 경우 emptyString(공백문자열) 을 반환해야 한다" {
        val actual = Sanitizer.sanitize(null)
        actual shouldBe ""
        println("@설계 : null 처리에 관한 책임과 역할은 Validator 가 담당한다")
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" {
        val actual = Sanitizer.sanitize("1")
        actual shouldBe "1"
    }

    " 숫자 여러개를 컴마(,) 구분자로 입력할 경우 그대로 반환한다" {
        val data: String? = "1,2,3,4345,345,345,34645,6,677"
        val actual = Sanitizer.sanitize(data)
        actual shouldBe data!!
    }
})
