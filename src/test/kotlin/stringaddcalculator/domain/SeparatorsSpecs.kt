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

        context("유효한 구분자 문자가 주어지면") {
            val separator = "*"
            it("새로운 구분자를 추가할 수 있다") {
                Separators().add(separator)
            }
        }

        it("중복되지 않은 구분자를 가진다") {
            val separators = Separators()
            separators.add(":")
            separators.add(",")
            separators.size shouldBe 2
        }
    }
})
