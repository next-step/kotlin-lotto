package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class BonusNumberTest : StringSpec({
    "보너스 볼을 생성한다." {
        BonusNumber("1")
    }

    "보너스 볼 입력이 존재하지 않으면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("보너스 볼 입력은 필수입니다.") {
            BonusNumber(null)
        }
    }

    "보너스 볼이 숫자가 아니면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("보너스 볼은 문자가 될 수 없습니다.") {
            BonusNumber("a")
        }
    }
})
