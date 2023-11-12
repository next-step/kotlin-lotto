package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({

    "로또 당첨 번호와 일치하는 개수가 0개 미만 7개 이상이면 예외가 발생한다." {
        listOf(-1, 7).forEach { count ->
            shouldThrowWithMessage<IllegalArgumentException>("당첨 번호와 일치하는 개수는 0개 이상, 6개 이하만 가능합니다.") {
                LottoRank.from(count, false)
            }
        }
    }

    "로또 당첨 번호와 일치하는 개수, 보너스 볼의 일치 여부에 따라 LottoRank 객체를 반환한다." {
        forAll(
            row(0, false, LottoRank.MISS),
            row(1, false, LottoRank.MISS),
            row(2, false, LottoRank.MISS),
            row(3, false, LottoRank.FIFTH),
            row(4, false, LottoRank.FOURTH),
            row(5, false, LottoRank.THIRD),
            row(5, true, LottoRank.SECOND),
            row(6, false, LottoRank.FIRST)
        ) { count, hasBonusBall, expected ->
            LottoRank.from(count, hasBonusBall) shouldBe expected
        }
    }
})
