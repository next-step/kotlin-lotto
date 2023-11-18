package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoRewardTest : FunSpec({
    test("1등의 조건은 당첨번호 6개 일치이다.") {
        LottoReward.valueOf(6, false) shouldBe LottoReward.FIRST
    }

    test("1등의 당첨 금액은 2_000_000_000원이다.") {
        LottoReward.FIRST.reward shouldBe 2_000_000_000
    }

    test("2등의 조건은 당첨번호 5개 일치 + 보너스 번호 일치이다.") {
        LottoReward.valueOf(5, true) shouldBe LottoReward.SECOND
    }

    test("2등의 당첨 금액은 30_000_000원이다.") {
        LottoReward.SECOND.reward shouldBe 30_000_000
    }

    test("3등의 조건은 당첨번호 5개 일치 + 보너스 번호 불일치이다.") {
        LottoReward.valueOf(5, false) shouldBe LottoReward.THIRD
    }

    test("3등의 당첨 금액은 1_500_000원이다.") {
        LottoReward.THIRD.reward shouldBe 1_500_000
    }

    test("4등의 조건은 당첨번호 4개 일치 + 보너스 번호 상관없음 이다.") {
        LottoReward.valueOf(4, true) shouldBe LottoReward.FOURTH
        LottoReward.valueOf(4, true) shouldBe LottoReward.FOURTH
    }

    test("4등의 당첨 금액은 50_000원이다.") {
        LottoReward.FOURTH.reward shouldBe 50_000
    }

    test("5등의 조건은 당첨번호 3개 일치 + 보너스 번호 상관없음 이다.") {
        LottoReward.valueOf(3, true) shouldBe LottoReward.FIFTH
        LottoReward.valueOf(3, true) shouldBe LottoReward.FIFTH
    }

    test("5등의 당첨 금액은 5_000원이다") {
        LottoReward.FIFTH.reward shouldBe 5_000
    }
})
