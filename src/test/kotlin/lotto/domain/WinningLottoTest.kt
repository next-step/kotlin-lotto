package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({
    val winningLottoNumbers = WinningLotto(LottoNumbers("1,2,3,4,5,6"))

    "일치 하는 로또의 수를 알 수 있다." {
        val lottoNumbers = LottoNumbers(
            setOf(
                LottoNumber.from(6), LottoNumber.from(5),
                LottoNumber.from(4), LottoNumber.from(3),
                LottoNumber.from(2), LottoNumber.from(1)
            )
        )

        winningLottoNumbers.correctCount(lottoNumbers) shouldBe 6
    }

    "각 등수 정상 결과 확인" {
        forAll(
            row("1,2,3,4,5,6", 6),
            row("1,2,3,4,5,7", 5),
            row("1,2,3,4,7,8", 4),
            row("1,2,3,7,8,9", 3),
        ) { lottoNumber, correctCount ->
            winningLottoNumbers.correctCount(LottoNumbers(lottoNumber)) shouldBe correctCount
        }
    }
})
