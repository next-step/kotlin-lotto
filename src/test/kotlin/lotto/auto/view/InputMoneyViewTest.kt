package lotto.auto.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.auto.port.IOSystem

internal class InputMoneyViewTest : BehaviorSpec({

    given("입력 view는") {
        val stubIOSystem = StubIOSystem("15000")
        val inputView = InputMoneyView(stubIOSystem)

        `when`("실행 시") {
            val result = inputView.getMoney()

            then("메시지를 출력하고, 구매 금액을 반환한다.") {
                stubIOSystem.screenBuffer shouldBe "구입 금액을 입력해 주세요."
                result shouldBe 10000
            }
        }
    }
})
