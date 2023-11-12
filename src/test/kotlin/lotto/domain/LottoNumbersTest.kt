package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.test.LottoNumberGenerator

class LottoNumbersTest : ExpectSpec({

    context("1,2,3,4,5,6 번호가 존재할 때") {
        val lottoNumbers = LottoNumbers(LottoNumberGenerator.generate(1, 2, 3, 4, 5, 6))

        expect("번호 포함 여부는 모두 true 로 반환한다.") {
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            numbers.forAll {
                lottoNumbers.contains(LottoNumber(it)) shouldBe true
            }

        }
    }

    expect("번호 개수가 6개이고 중복되지 않으면 객체를 생성한다.") {
        val numbers = LottoNumberGenerator.generate(1, 2, 3, 4, 5, 6)
        LottoNumbers(numbers)
    }

    expect("번호 개수가 6개 보다 작으면 예외가 발생한다.") {
        val lottoNumbers = LottoNumberGenerator.generate(1, 2, 3, 4, 5)
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(lottoNumbers)
        }
    }

    expect("번호 개수가 6개 보다 많으면 예외가 발생한다.") {
        val lottoNumbers = LottoNumberGenerator.generate(1, 2, 3, 4, 5, 6, 7)
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(lottoNumbers)
        }
    }

    expect("번호가 중복되면 예외가 발생한다.") {
        val lottoNumbers = LottoNumberGenerator.generate(1, 2, 3, 4, 5, 5)

        shouldThrow<IllegalArgumentException> {
            LottoNumbers(lottoNumbers)
        }
    }
})
