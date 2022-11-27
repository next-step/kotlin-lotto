package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoNumbersTest : BehaviorSpec({
    given("로또를 자동으로 구매했을 때") {
        `when`("랜덤으로 로또 번호를 생성한다면") {
            val result = LottoNumbers.makeRandomLottoNumbers()

            then("중복없는 6자리의 로또 번호가 생성된다.") {
                result.size shouldBe 6
            }
        }
    }
})
