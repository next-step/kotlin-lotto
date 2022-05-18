package stringaddcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SeparatorsSpecs : DescribeSpec({

    describe("구분자 목록은") {
        it("쉼표와 콜론을 기본 구분자로 가진다") {
            val separators = Separators()
            ("," in separators) shouldBe true
            (":" in separators) shouldBe true
        }
    }
})
