package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    "getMinCountOfMatchForWin()가 5등 기준인 3을 반환한다" {
        LottoRank.getMinCountOfMatchForWin() shouldBe 3
    }

    "countOfMatch가 0인 경우, LottoRank.MISS_WITH_ZERO_MATCH 반환 된다" {
        LottoRank.valueOf(0, false) shouldBe LottoRank.MISS_WITH_ZERO_MATCH
    }
})
