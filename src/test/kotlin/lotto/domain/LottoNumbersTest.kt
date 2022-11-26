package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoNumbersTest : BehaviorSpec({
    given("로또 번호를") {
        `when`("랜덤으로 생성할 때") {
            val result = LottoNumbers.createRandom()

            then("중복없는 6개의 로또 번호를 생성한다.") {
                result.getLottoNumbers().distinct().size shouldBe 6
            }
        }
    }
})
