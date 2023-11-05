package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import lotto.test.LottoNumberGenerator

class LottoNumbersTest : ExpectSpec({


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
