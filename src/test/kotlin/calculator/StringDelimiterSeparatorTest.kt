package calculator

import calculator.StringDelimiterSeparator.Companion.split
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly

@DisplayName("문자열 구분자 분리")
class StringDelimiterSeparatorTest : StringSpec({

    "정규식으로 생성" {
        listOf(
            "^//(?<delimiter>.)\n(?<strings>.*)$".toRegex(),
            "^(?<strings>.*)\t//(?<delimiter>.)$".toRegex()
        ).forAll {
            shouldNotThrowAny {
                StringDelimiterSeparator(it)
            }
        }
    }

    "정규식에 구분자와 문자열의 그룹 이름은 필수" {
        listOf(
            "^//.\n.*$".toRegex(),
            "^.*\t//.$".toRegex()
        ).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                StringDelimiterSeparator(it)
            }
        }
    }

    "구분자가 있으면 일치하는 구분자로 구분" {
        // given
        val separator = StringDelimiterSeparator("^//(?<delimiter>.)\n(?<strings>.*)$".toRegex())
        // when
        val strings: Collection<String>? = "//;\n1;2;3" split separator
        // then
        strings shouldContainExactly listOf("1", "2", "3")
    }

    "일치하는 구분자가 존재하지 않으면 값이 없음" {
        // given
        val separator = StringDelimiterSeparator("^//(?<delimiter>.)\n(?<strings>.*)$".toRegex())
        // when
        val strings: Collection<String> = "1,2,3" split separator
        // then
        strings.shouldBeEmpty()
    }
})
