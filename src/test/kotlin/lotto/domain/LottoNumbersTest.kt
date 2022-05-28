package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberException
import lotto.exception.InvalidLottoNumberSizeException

class LottoNumbersTest : FunSpec({

    test("Lotto 숫자는 6개로 구성된다.") {
        shouldThrow<InvalidLottoNumberSizeException> {
            LottoNumbers.of(1)
        }
        shouldThrow<InvalidLottoNumberSizeException> {
            LottoNumbers.of(1, 2, 3, 4, 5, 6, 7)
        }
    }

    test("로또 숫자는 중복이 없어야 한다.") {
        shouldThrow<DuplicateLottoNumberException> {
            LottoNumbers.of(1, 1, 1, 4, 5, 6)
        }
    }

    test("로또 번호는 1 부터 45까지 허용된다.") {
        shouldThrow<InvalidLottoNumberException> {
            LottoNumbers.of(0, 2, 3, 4, 5, 6)
        }
        shouldThrow<InvalidLottoNumberException> {
            LottoNumbers.of(1, 2, 3, 4, 5, 100)
        }
    }

    test("로또 숫자끼리 비교가 가능하다.") {
        val numbers1 = LottoNumbers.of(2, 1, 6, 5, 4, 3)
        val numbers2 = LottoNumbers.of(3, 4, 5, 6, 7, 8)
        numbers1.matchingNumbers(numbers2) shouldBe listOf(3, 4, 5, 6).map { LottoNumber.of(it) }
    }

    test("로또번호에 특정 숫자가 포함되어 있는지 확인 가능합니다.") {
        val lottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        (1 in lottoNumbers) shouldBe true
        (7 in lottoNumbers) shouldBe false

        (LottoNumber.of(1) in lottoNumbers) shouldBe true
        (LottoNumber.of(7) in lottoNumbers) shouldBe false
    }
})
