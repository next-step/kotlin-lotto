package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import lotto.test.LottoNumberGenerator

class LottoNumbersTest : ExpectSpec({

    context("1,2,3,4,5,6 번호가 존재할 때") {
        val lottoNumbers = LottoNumberGenerator.generate(1, 2, 3, 4, 5, 6)

        expect("1을 입력하면 contains 결과는 true이다.") {
            val target = LottoNumber(1)
            LottoNumbers(lottoNumbers).contains(target) shouldBe true
        }

        expect("6을 입력하면 contains 결과는 true이다.") {
            val target = LottoNumber(6)
            LottoNumbers(lottoNumbers).contains(target) shouldBe true
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
