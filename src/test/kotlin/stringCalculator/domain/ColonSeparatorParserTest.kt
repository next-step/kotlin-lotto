package stringCalculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class ColonSeparatorParserTest : StringSpec({
    ": 구분자를 쓰는 식을 입력시 구분자 확인 함수가 true를 반환한다." {
        listOf("1:2:3:4", "1:45:2", "1:65:77").forAll { formula ->
            ColonSeparatorParser(formula).isUsingSeparator() shouldBe true
        }
    }

    ": 구분자를 사용하지 않는 식을 입력시 구분자 확인 함수가 false를 반환한다." {
        listOf("1,2,3,4", "1,45,2", "1,65,77", "//**\n1**2**6").forAll { formula ->
            ColonSeparatorParser(formula).isUsingSeparator() shouldBe false
        }
    }

    ": 를 구분자로 숫자 리스트를 반환한다." {
        ColonSeparatorParser("1:2:3:4").parseFormula().sorted() shouldBe listOf(1, 2, 3, 4).sorted()
        ColonSeparatorParser("1:45:2").parseFormula().sorted() shouldBe listOf(1, 2, 45).sorted()
        ColonSeparatorParser("1:65:77").parseFormula().sorted() shouldBe listOf(1, 65, 77).sorted()
    }
})
