package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class ManualLottoAmountTest : StringSpec({
    "수동 로또 갯수를 생성한다." {
        ManualLottoAmount(3)
    }

    "수동 로또 갯수가 음수라면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("수동 로또 갯수는 유효한 양수로 입력해야합니다.") {
            ManualLottoAmount(-3)
        }
    }
})
