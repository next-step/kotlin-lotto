package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class PrizeTest : FunSpec({
    context("상금이 꽝이 아닌지 여부를 반환한다") {
        withData(
            Pair(Prize.FIRST, true),
            Pair(Prize.SECOND, true),
            Pair(Prize.THIRD, true),
            Pair(Prize.FOURTH, true),
            Pair(Prize.FIFTH, true),
            Pair(Prize.MISS, false),
        ) { (prize, expected) ->
            prize.isNotMiss() shouldBe expected
        }
    }

    context("상금이 보너스번호가 일치했는지 반환한다") {
        withData(
            Pair(Prize.FIRST, false),
            Pair(Prize.SECOND, true),
            Pair(Prize.THIRD, false),
            Pair(Prize.FOURTH, false),
            Pair(Prize.FIFTH, false),
            Pair(Prize.MISS, false),
        ) { (prize, expected) ->
            prize.isBonusMatched() shouldBe expected
        }
    }

    context("일치한 로또번호 개수와 보너스일치 여부를 받아 상금을 반환한다") {
        withData(
            Triple(0, false, Prize.MISS),
            Triple(0, true, Prize.MISS),
            Triple(1, false, Prize.MISS),
            Triple(1, true, Prize.MISS),
            Triple(2, false, Prize.MISS),
            Triple(2, true, Prize.MISS),
            Triple(3, false, Prize.FIFTH),
            Triple(3, true, Prize.FIFTH),
            Triple(4, false, Prize.FOURTH),
            Triple(4, true, Prize.FOURTH),
            Triple(5, false, Prize.THIRD),
            Triple(5, true, Prize.SECOND),
            Triple(6, false, Prize.FIRST),
            Triple(6, true, Prize.FIRST),
        ) { (matchedCount, bonusMatched, prize) ->
            Prize.match(matchedCount, bonusMatched) shouldBe prize
        }
    }
})
