package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoRewardTest : FunSpec({
    test("2등의 조건은 당첨번호 5개 일치 + 보너스 번호 일치이다.") {
        LottoReward.SECOND.matchCount shouldBe 5
        LottoReward.SECOND.bonusMatch shouldBe true
    }

    test("2등의 당첨 금액은 30000000원이다.") {
        LottoReward.SECOND.reward shouldBe 30_000_000
    }
})
