package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.view.LottoResultMessage

class LottoResultTest : StringSpec({
    val winningLottoNumbers = WinningLotto(LottoNumbers.from("1,2,3,4,5,6"))

    "각 등수 정상 결과 확인" {
        forAll(
            row("1,2,3,4,5,6", LottoRanking.FIRST),
            row("1,2,3,4,5,7", LottoRanking.THIRD),
            row("1,2,3,4,7,8", LottoRanking.FOURTH),
            row("1,2,3,7,8,9", LottoRanking.FIFTH),
        ) { lottoNumber, ranking ->
            val lottoRanking = LottoResult().lottoRanking(
                listOf(LottoNumbers.from(lottoNumber)), winningLottoNumbers
            )

            lottoRanking[ranking] shouldBe 1
        }
    }

    "수익 별 메시지 확인" {
        forAll(
            row(1f, "본전이"),
            row(0.5f, "손해"),
            row(1.5f, "이득이"),
        ) { rateOfReturn, message ->
            LottoResultMessage.message(rateOfReturn) shouldBe message
        }
    }
})
