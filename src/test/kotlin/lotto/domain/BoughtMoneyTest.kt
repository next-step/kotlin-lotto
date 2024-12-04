package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class BoughtMoneyTest : StringSpec({

    "구입 금액을 생성한다." {
        BoughtMoney(1000)
    }

    "구입 금액이 음수라면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("구입 금액은 유효한 양수로 입력해야합니다.") {
            BoughtMoney(-1000)
        }
    }
})
