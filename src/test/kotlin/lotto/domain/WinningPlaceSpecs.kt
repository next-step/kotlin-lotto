package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningPlace.BLANK
import lotto.domain.WinningPlace.FIFTH
import lotto.domain.WinningPlace.FIRST
import lotto.domain.WinningPlace.FOURTH
import lotto.domain.WinningPlace.SECOND
import lotto.domain.WinningPlace.THIRD

class WinningPlaceSpecs : DescribeSpec({

    describe("당첨 등수는") {
        it("당첨 번호와 일치하는 번호의 개수가 6개면 1등이다") {
            WinningPlace.of(6, true) shouldBe FIRST
            WinningPlace.of(6, false) shouldBe FIRST
        }
        it("당첨 번호와 일치하는 번호의 개수가 5개고 보너스볼이 일치하면 2등이다") {
            WinningPlace.of(5, true) shouldBe SECOND
        }
        it("당첨 번호와 일치하는 번호의 개수가 5개면 3등이다") {
            WinningPlace.of(5, false) shouldBe THIRD
        }
        it("당첨 번호와 일치하는 번호의 개수가 4개면 4등이다") {
            WinningPlace.of(4, true) shouldBe FOURTH
            WinningPlace.of(4, false) shouldBe FOURTH
        }
        it("당첨 번호와 일치하는 번호의 개수가 3개면 5등이다") {
            WinningPlace.of(3, true) shouldBe FIFTH
            WinningPlace.of(3, false) shouldBe FIFTH
        }
        it("당첨 번호와 일치하는 번호의 개수가 2개 이하면 꽝이다") {
            WinningPlace.of(2, true) shouldBe BLANK
            WinningPlace.of(2, false) shouldBe BLANK
            WinningPlace.of(0, true) shouldBe BLANK
            WinningPlace.of(0, false) shouldBe BLANK
        }
    }
})
