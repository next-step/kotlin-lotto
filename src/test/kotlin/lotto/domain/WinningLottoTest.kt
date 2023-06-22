package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumberSupports.toLottoNumbers
import lotto.domain.LottoResult.FIFTH_PLACE
import lotto.domain.LottoResult.FIRST_PLACE
import lotto.domain.LottoResult.FOURTH_PLACE
import lotto.domain.LottoResult.LOSE
import lotto.domain.LottoResult.SECOND_PLACE
import lotto.domain.LottoResult.THIRD_PLACE

class WinningLottoTest : FreeSpec({

    "로또 번호로 당첨 결과를 확인 할 수 있다. 당첨 번호(1, 2, 3, 4, 5, 6)만 매칭되는 경우" - {
        withData(
            listOf(1, 2, 3, 4, 5, 6) to FIRST_PLACE,
            listOf(1, 2, 3, 4, 5, 45) to THIRD_PLACE,
            listOf(1, 2, 3, 5, 7, 45) to FOURTH_PLACE,
            listOf(1, 2, 3, 7, 44, 45) to FIFTH_PLACE,
            listOf(1, 2, 42, 43, 44, 45) to LOSE,
            listOf(1, 41, 42, 43, 44, 45) to LOSE,
            listOf(40, 41, 42, 43, 44, 45) to LOSE,
        ) { (lottoNumber, grade) ->
            val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers()), LottoNumber.of(10))
            val lotto = Lotto(lottoNumber.toLottoNumbers())
            winningLotto.match(lotto) shouldBe grade
        }
    }

    "로또 번호로 당첨 결과(2등)를 확인 할 수 있다. 당첨 번호(1, 2, 3, 4, 5, 6), 보너스 7" {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 7)
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers()), LottoNumber.of(7))

        val lotto = Lotto(lottoNumber.toLottoNumbers())
        winningLotto.match(lotto) shouldBe SECOND_PLACE
    }

    "당첨 번호와 보너스는 중복될 수 없다." - {
        withData(
            WinningLottoTestData(listOf(1, 2, 3, 4, 5, 6), 1),
            WinningLottoTestData(listOf(1, 2, 3, 4, 5, 6), 2),
            WinningLottoTestData(listOf(6, 8, 3, 23, 45, 32), 32),
            WinningLottoTestData(listOf(6, 8, 3, 23, 45, 32), 45)
        ) { (winningNumbers, bonusNumber) ->

            shouldThrow<IllegalArgumentException> {
                WinningLotto(winningNumbers, bonusNumber)
            }
        }
    }
}) {
    companion object {
        data class WinningLottoTestData(
            val winningNumber: Lotto,
            val bonusNumber: LottoNumber
        ) {
            constructor(numbers: List<Int>, bonus: Int) : this(Lotto(numbers.toLottoNumbers()), LottoNumber.of(bonus))
        }
    }
}
