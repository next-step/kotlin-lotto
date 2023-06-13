package calculator

import calculator.WholeNumber.Companion.totalNumber
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("0 또는 양수 테스트")
class WholeNumberTest : StringSpec({

    "0 또는 양수로 생성" {
        listOf(0, 1, 1000, Int.MAX_VALUE)
            .forAll {
                shouldNotThrowAny { WholeNumber(it) }
            }
    }

    "문자열로 이루어진 숫자로 생성" {
        listOf("0", "1", "1000")
            .forAll {
                shouldNotThrowAny { WholeNumber(it) }
            }
    }

    "음수로는 생성 불가" {
        listOf(Int.MIN_VALUE, -10, -1)
            .forAll {
                shouldThrowExactly<IllegalArgumentException> { WholeNumber(it) }
            }
    }

    "1과 2를 더하면 3" {
        WholeNumber(1) + WholeNumber(2) shouldBe WholeNumber(3)
    }

    "1과 2의 리스트를 합산하면 3" {
        // given
        val oneAndTwo: List<WholeNumber> = listOf(WholeNumber(1), WholeNumber(2))
        // when & then
        oneAndTwo.totalNumber shouldBe WholeNumber(3)
    }
})
