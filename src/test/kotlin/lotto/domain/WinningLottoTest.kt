package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumberSupports.toLottoNumbers
import lotto.domain.LottoResult.*

class WinningLottoTest : FreeSpec({

    "로또 번호로 당첨 결과를 확인 할 수 있다. 당첨 번호(1, 2, 3, 4, 5, 6)" - {
        withData(
            listOf(1, 2, 3, 4, 5, 6) to FIRST_PLACE,
            listOf(1, 2, 3, 4, 5, 45) to SECOND_PLACE,
            listOf(1, 2, 3, 4, 44, 45) to THIRD_PLACE,
            listOf(1, 2, 3, 43, 44, 45) to FOURTH_PLACE,
            listOf(1, 2, 42, 43, 44, 45) to LOSE,
            listOf(1, 41, 42, 43, 44, 45) to LOSE,
            listOf(40, 41, 42, 43, 44, 45) to LOSE,
        ) { (lottoNumber, grade) ->
            val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers()))
            val lotto = Lotto(lottoNumber.toLottoNumbers())
            winningLotto.match(lotto) shouldBe grade
        }
    }
})
