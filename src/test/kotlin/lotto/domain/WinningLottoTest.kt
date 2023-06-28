package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({
    val winningLottoNumbers = WinningLotto(LottoNumbers.from("1,2,3,4,5,6"), LottoNumber(7))

    "일치 하는 로또의 수를 알 수 있다." {
        val lottoNumbers = LottoNumbers(
            setOf(
                LottoNumber(6), LottoNumber(5),
                LottoNumber(4), LottoNumber(3),
                LottoNumber(2), LottoNumber(1)
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
            winningLottoNumbers.correctCount(LottoNumbers.from(lottoNumber)) shouldBe correctCount
        }
    }

    "보너스 볼은 6자리 로또 번호와 달라야 한다." {
        val exception = shouldThrow<IllegalArgumentException> {
            WinningLotto(
                LottoNumbers.from("1,2,3,4,5,6"), LottoNumber(6)
            )
        }

        exception.message shouldBe "보너스 볼은 6개의 로또번호와 달라야 합니다."
    }

    "보너스 볼 포함 여부 확인" {
        winningLottoNumbers.matchedBonusBall(LottoNumbers.from("1,2,3,4,5,7")) shouldBe true
    }
})
