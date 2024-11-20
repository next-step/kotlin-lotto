package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class SeparatorsTest : StringSpec({

    "기본 구분자로 \",\"와 \";\"를 가진다." {
        val separators = Separators()
        separators.isExist(",") shouldBe true
        separators.isExist(";") shouldBe true
    }

    "구분자를 추가할 수 있다." {

        forAll(
            row("!!"),
            row(", ,"),
            row(";;"),
            row(">_<"),
            row("ㅇㅁㅇ"),
        ) { value ->
            val separators = Separators()
            val afterSeparators = separators.addSeparator(value)
            afterSeparators.isExist(value) shouldBe true
        }
    }

    "구분자는 공백일 수 없다." {
        val separators = Separators()
        val exception = shouldThrowExactly<IllegalArgumentException> {
            separators.addSeparator(" ")
        }
        exception.message shouldBe "구분자는 공백일 수 없습니다."
    }
})
