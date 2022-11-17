package nextstep.mission.calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class InputParserTest : StringSpec({

    "쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리하여 숫자 리스트를 반환한다." {
        InputParser.parse("1,2:3") shouldBe listOf(1, 2, 3)
    }

    """//와 \n 사이에 위치하는 문자를 커스텀 구분자로 사용하여 분리한 숫자 리스트를 반환한다.""" {
        InputParser.parse("//;\n1;2;3") shouldBe listOf(1, 2, 3)
    }
})
