package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class WinningLottoNumbersTest : FunSpec({

    test("WinningLottoNumbers 정상 생성") {
        val lottoNumbers = LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))
        val bonusLottoNumber = LottoNumber(7)

        val winningLottoNumbers = WinningLottoNumbers(lottoNumbers, bonusLottoNumber)
        winningLottoNumbers.lottoNumbers shouldBe lottoNumbers
        winningLottoNumbers.bonusLottoNumber shouldBe bonusLottoNumber
    }

    test("보너스 번호가 당점번호와 중복되면 IllegalArgumentException throw") {
        val lottoNumbers = LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))
        val bonusLottoNumber = LottoNumber(1)

        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers(lottoNumbers, bonusLottoNumber)
        }
    }
})
