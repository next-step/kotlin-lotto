package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
class LottoRankTest : StringSpec({

    "3개의 숫자가 일치하는 경우 5등(FIFTH) 반환한다." {
        LottoRank.of(3, false) shouldBe LottoRank.FIFTH
    }

    "5개의 숫자만 일치하는 경우 3등을 반환한다." {
        LottoRank.of(5, false) shouldBe LottoRank.THIRD
    }

    "5개의 숫자가 일치하고 보너스 넘버까지 가지고 있는 경우 2등을 반환한다." {
        LottoRank.of(5, true) shouldBe LottoRank.SECOND
    }
})
