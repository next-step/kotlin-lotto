package stringaddcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SeparatorSpecs : DescribeSpec({

    describe("구분자는") {
        it("구분자로 사용할 문자를 가질 수 있다") {
            Separator("/").value shouldBe "/"
        }
    }
})
