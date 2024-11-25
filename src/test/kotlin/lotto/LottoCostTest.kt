package lotto

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoCostTest : StringSpec({
    "구입 금액을 생성한다." {
        LottoCost("1000")
    }

    "구입 금액이 존재하지 않으면 예외를 던진다." {
        shouldThrowMessage("구입 금액은 필수입니다.") {
            LottoCost(null)
        }
    }

    "숫자가 아닌 구입 금액이라면 예외를 던진다." {
        shouldThrowMessage("구입 금액은 숫자만 입력가능합니다.") {
            LottoCost("천원")
        }
    }

    "구입 금액이 음수라면 예외를 던진다." {
        shouldThrowMessage("구입 금액은 유효한 양수로 입력해야합니다.") {
            LottoCost("-1000")
        }
    }

    "로또 구입 갯수를 계산한다." {
        val lottoCosts = listOf(
            LottoCost("1000") to 1,
            LottoCost("1500") to 1,
            LottoCost("10000") to 10,
        )


        lottoCosts.forAll { (lottoCost, expected) ->
            lottoCost.calculateBoughtLottoAmount() shouldBe expected
        }
    }
})
