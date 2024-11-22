package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields

class LottoGameTest : StringSpec({
    "로또 머신을 통해 로또 라인들을 생성할 수 있다." {
        forAll(
            row(listOf(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 8))),
            row(listOf(listOf(1, 3, 15, 24, 33, 45), listOf(6, 8, 9, 14, 17, 28))),
        ) { lottoNumbers ->
            val lottoGame =
                LottoGame(
                    LottoPurchaseAmount("2000"),
                    CustomLottoBallBallMachine(lottoNumbers),
                )
            lottoGame.getLottoLines() shouldBeEqualToComparingFields
                lottoNumbers.map {
                    LottoLine(it.map { LottoBall(it) }.toList())
                }
        }
    }
})
