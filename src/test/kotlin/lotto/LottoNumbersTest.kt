package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoNumbersTest : BehaviorSpec({
    given("로또 번호가 될 수 있는 숫자의") {
        `when`("총 개수는") {
            then("45개 이다.") {
                LottoNumbers.getNumbers().size shouldBe 45
            }
        }
    }
})
