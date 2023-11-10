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
                LottoRank.from(count)
            }
        }
    }

    "로또 당첨 번호와 일치하는 개수에 따라 LottoRank 객체를 반환한다." {
        forAll(
            row(0, LottoRank.MISS),
            row(1, LottoRank.MISS),
            row(2, LottoRank.MISS),
            row(3, LottoRank.THREE),
            row(4, LottoRank.FOUR),
            row(5, LottoRank.FIVE),
            row(6, LottoRank.SIX),
        ) { count, rank ->
            LottoRank.from(count) shouldBe rank
        }
    }
},)
