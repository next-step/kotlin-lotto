package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumbersTest : StringSpec({
    "로또 숫자가 6개가 아닌 경우 예외가 발생한다." {
        val invalidLottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(30),
            LottoNumber(45)
        )
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(invalidLottoNumbers)
        }
    }

    "로또 숫자가 6개 중 중복 숫자가 있으면 예외가 발생한다." {
        val invalidLottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(30),
            LottoNumber(30),
            LottoNumber(30),
            LottoNumber(30),
            LottoNumber(45)
        )
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(invalidLottoNumbers)
        }
    }

    "각 로또는 1~45의 서로 다른 숫자 6개로 구성된다." {
        val validLottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        LottoNumbers(validLottoNumbers)
    }
})
