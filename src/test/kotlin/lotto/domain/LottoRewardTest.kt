package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoReward
 */
class LottoRewardTest : FunSpec({

    context("fun from()") {

        test("6자리 일치 1등") {
            LottoReward.from(6, false) shouldBe LottoReward.FIRST
        }

        test("5자리 일치 및 보너스 일치 2등") {
            LottoReward.from(5, true) shouldBe LottoReward.SECOND
        }

        test("5자리 일치 및 보너스 불일치 3등") {
            LottoReward.from(5, false) shouldBe LottoReward.THIRD
        }

        test("4자리 일치 4등") {
            LottoReward.from(4, false) shouldBe LottoReward.FIRTH
        }

        test("3자리 일치 5등") {
            LottoReward.from(3, false) shouldBe LottoReward.FIFTH
        }

        test("2자리 이하 꽝") {
            LottoReward.from(2, false) shouldBe LottoReward.FAIL
            LottoReward.from(1, false) shouldBe LottoReward.FAIL
            LottoReward.from(0, false) shouldBe LottoReward.FAIL
        }
    }
})
