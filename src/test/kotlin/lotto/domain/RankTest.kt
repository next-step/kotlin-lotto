package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RankTest : StringSpec({

    "지난 주 당첨 번호를 사용해 각 로또의 일치 개수를 얻는다." {
        val lottos = Lottos(
            mutableListOf(
                LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                ),
                LottoNumbers(
                    listOf(
                        LottoNumber(11),
                        LottoNumber(12),
                        LottoNumber(13),
                        LottoNumber(14),
                        LottoNumber(15),
                        LottoNumber(16)
                    )
                ),
                LottoNumbers(
                    listOf(
                        LottoNumber(21),
                        LottoNumber(22),
                        LottoNumber(23),
                        LottoNumber(24),
                        LottoNumber(25),
                        LottoNumber(26)
                    )
                )
            )
        )

        val winnerNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val rankThree = Rank.MATCH_THREE
        val rankFour = Rank.MATCH_FOUR
        val rankFive = Rank.MATCH_FIVE
        val rankSix = Rank.MATCH_SIX

        rankThree.getRank(lottos, winnerNumbers)
        rankFour.getRank(lottos, winnerNumbers)
        rankFive.getRank(lottos, winnerNumbers)
        rankSix.getRank(lottos, winnerNumbers)

        rankThree.count shouldBe 0
        rankFour.count shouldBe 0
        rankFive.count shouldBe 0
        rankSix.count shouldBe 1
    }
})
