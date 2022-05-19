package calculator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FreeSpec({

    "기본 구분자로 구분되는 경우" - {
        "쉼표(,) 구분자로 구분된 각 숫자의 합을 반환한다." {
            StringCalculator().calculate("4,2") shouldBe 6
        }
        "콜론(:) 구분자로 구분된 각 숫자의 합을 반환한다." {
            StringCalculator().calculate("4:2") shouldBe 6
        }
        "쉼표(,)와 콜론(:) 구분자로 구분된 각 숫자의 합을 반환한다." {
            StringCalculator().calculate("4,2:4") shouldBe 10
        }
    }

    "커스텀 구분자로 구분되는 경우" - {
        "//와 \n 문자 사이에 커스텀 구분자로 구분된 각 숫자의 합을 반환한다." {
            StringCalculator().calculate("//;\n4;2;4") shouldBe 10
        }
    }

    "숫자 하나를 문자열로 입력할 경우" - {
        "해당 숫자를 반환한다" {
            StringCalculator().calculate("4") shouldBe 4
        }
    }
})
