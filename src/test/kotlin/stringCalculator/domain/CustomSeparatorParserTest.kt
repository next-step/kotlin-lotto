package stringCalculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import stringCalculator.domain.FormulaFormatException.CustomSeparatorFormatException

class CustomSeparatorParserTest : StringSpec({
    "커스텀 구분자를 쓰는 식을 입력시 구분자 확인 함수가 true를 반환한다." {
        listOf("//$\\n1$2$3$4", "//%\\n1%45%2", "//+\\n1+65+77").forAll { formula ->
            CustomSeparatorParser(formula).isUsingSeparator() shouldBe true
        }
    }

    "커스텀 구분자를 사용하지 않는 식을 입력시 구분자 확인 함수가 false를 반환한다." {
        listOf("1,2,3,4", "1,45,2", "1:65:77", "1:2:4:7").forAll { formula ->
            CustomSeparatorParser(formula).isUsingSeparator() shouldBe false
        }
    }

    "커스텀 구분자를 이용해 구분해낸 숫자 리스트를 반환한다." {
        CustomSeparatorParser("//$\\n1$2$3$4").parseFormula().sorted() shouldBe listOf(1, 2, 3, 4).sorted()
        CustomSeparatorParser("//%\\n1%45%2").parseFormula().sorted() shouldBe listOf(1, 2, 45).sorted()
        CustomSeparatorParser("//+\\n1+65+77").parseFormula().sorted() shouldBe listOf(1, 65, 77).sorted()
    }

    "커스텀 구분자 입력 형식 중 prefix 는 식 내 존재하나 커스텀 구분자 입력 형식을 못맞출 경우 에러를 발생시킨다." {
        listOf("//$\\z1$2$3$4", "//%1%45%2", "//^^^&&1+65+77").forAll { formula ->
            shouldThrow<CustomSeparatorFormatException> { CustomSeparatorParser(formula).parseFormula() }
        }
    }
})
