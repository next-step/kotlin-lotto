package lotto

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoCostTest : StringSpec({
    "구입 금액을 생성한다." {
        LottoCost(1000, 0)
    }


    "구입 금액이 음수라면 예외를 던진다." {
        shouldThrowMessage("구입 금액은 유효한 양수로 입력해야합니다.") {
            LottoCost(-1000, 0)
        }
    }

    "자동 로또 구입 갯수를 계산한다." {
        forAll(
            row(LottoCost(1000, 0), 1),
            row(LottoCost(1000, 1), 0),
            row(LottoCost(1500, 0), 1),
            row(LottoCost(1500, 1), 0),
            row(LottoCost(10000, 2), 8),
        ) { lottoCost, expected ->
            lottoCost.autoLottoAmount shouldBe expected
        }
    }

    "수동 구입 갯수가 구입 가능 숫자를 능가하면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("구입 가능한 로또 갯수를 초과했습니다.") {
            LottoCost(1000, 2)
        }
    }
})
