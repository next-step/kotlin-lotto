package lotto.model

import io.kotest.core.spec.style.StringSpec
import lotto.LottoFixture

class RoundTest : StringSpec({
    "1등 당첨번호를 입력하면 1등 당첨자를 집계할수 있어야한다" {

        val round = LottoFixture.Round.winnerAggregate(LottoFixture.winner1st)
    }
})
