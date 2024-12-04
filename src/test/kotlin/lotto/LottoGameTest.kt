package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BoughtMoney

class LottoGameTest : StringSpec({

    val sut = LottoGame()

    "구입 금액을 반환한다." {
        val actual = sut.parseInputMoney("1000")

        actual shouldBe BoughtMoney(1000)
    }

    "구립 금액이 존재하지 않으면 예외를 반환한다." {
        shouldThrowWithMessage<IllegalArgumentException>("구입 금액은 필수입니다.") {
            sut.parseInputMoney(null)
        }
    }

    "구입 금액이 숫자가 아니면 예외를 반환한다." {
        shouldThrowWithMessage<IllegalArgumentException>("구입 금액은 숫자만 입력가능합니다.") {
            sut.parseInputMoney("abc")
        }
    }
})
