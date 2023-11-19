package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRuleTest : StringSpec({
    "로또 등수를 계산할 수 있다." {
        listOf(
            Pair(listOf(7, 8, 9, 10, 11, 12), Prize.NONE_PRIZE),
            Pair(listOf(1, 8, 9, 10, 11, 12), Prize.NONE_PRIZE),
            Pair(listOf(1, 2, 9, 10, 11, 12), Prize.NONE_PRIZE),
            Pair(listOf(1, 2, 3, 10, 11, 12), Prize.FOURTH_PRIZE),
            Pair(listOf(1, 2, 3, 4, 11, 12), Prize.THIRD_PRIZE),
            Pair(listOf(1, 2, 3, 4, 5, 11), Prize.SECOND_PRIZE),
            Pair(listOf(1, 2, 3, 4, 5, 6), Prize.FIRST_PRIZE),
        ).forEach { pair ->
            LottoRule(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
                .calculateResult(listOf(Lotto.from(pair.first)))
                .lottoRanking[pair.second]
            shouldBe(1)
        }
    }
})
