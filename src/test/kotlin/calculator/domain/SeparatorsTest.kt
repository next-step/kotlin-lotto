package calculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SeparatorsTest : StringSpec({

    "초기 구분자는 (,), (:) 이다." {
        val separators = Separators()
        separators.separators shouldBe mutableListOf(Separator(","), Separator(":"))
    }

    "구분자를 추가할 수 있다." {
        val separators = Separators()
        separators.add(Separator(":"))
        separators.separators shouldBe mutableListOf(Separator(","), Separator(":"), Separator(":"))
    }
})
