package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RankTest : StringSpec({
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
            )
        )
    )

    "지난 주 당첨 번호를 사용해 각 로또의 일치 개수를 얻는다." {
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(11)
        )
        val lastWinnerNumbers = LottoNumbers(lottoNumbers)
        val bonusBall = LottoNumber(7)

        val winnerNumber = WinningNumber(lastWinnerNumbers, bonusBall)

        val rankFirst = Rank.FIRST.getRank(lottos, winnerNumber)
        val rankSecond = Rank.SECOND.getRank(lottos, winnerNumber)
        val rankThird = Rank.THIRD.getRank(lottos, winnerNumber)
        val rankFour = Rank.FOURTH.getRank(lottos, winnerNumber)
        val rankFifth = Rank.FIFTH.getRank(lottos, winnerNumber)

        rankFirst.count shouldBe 0
        rankSecond.count shouldBe 0
        rankThird.count shouldBe 1
        rankFour.count shouldBe 0
        rankFifth.count shouldBe 0
    }

    "로또 당첨 번호가 5개 일치 할 경우, 보너스 볼도 일치하면 2등이 된다." {
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(7)
        )
        val lastWinnerNumbers = LottoNumbers(lottoNumbers)
        val bonusBall = LottoNumber(6)

        val winnerNumber = WinningNumber(lastWinnerNumbers, bonusBall)

        val rankFirst = Rank.FIRST.getRank(lottos, winnerNumber)
        val rankSecond = Rank.SECOND.getRank(lottos, winnerNumber)
        val rankThird = Rank.THIRD.getRank(lottos, winnerNumber)
        val rankFour = Rank.FOURTH.getRank(lottos, winnerNumber)
        val rankFifth = Rank.FIFTH.getRank(lottos, winnerNumber)

        rankFirst.count shouldBe 0
        rankSecond.count shouldBe 1
        rankThird.count shouldBe 0
        rankFour.count shouldBe 0
        rankFifth.count shouldBe 0
    }

    "로또 당첨 번호가 5개 일치 할 경우, 보너스 볼이 일치하지 않으면 3등이 된다." {
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(7)
        )
        val lastWinnerNumbers = LottoNumbers(lottoNumbers)
        val bonusBall = LottoNumber(10)

        val winnerNumber = WinningNumber(lastWinnerNumbers, bonusBall)

        val rankFirst = Rank.FIRST.getRank(lottos, winnerNumber)
        val rankSecond = Rank.SECOND.getRank(lottos, winnerNumber)
        val rankThird = Rank.THIRD.getRank(lottos, winnerNumber)
        val rankFour = Rank.FOURTH.getRank(lottos, winnerNumber)
        val rankFifth = Rank.FIFTH.getRank(lottos, winnerNumber)

        rankFirst.count shouldBe 0
        rankSecond.count shouldBe 0
        rankThird.count shouldBe 1
        rankFour.count shouldBe 0
        rankFifth.count shouldBe 0
    }
})
