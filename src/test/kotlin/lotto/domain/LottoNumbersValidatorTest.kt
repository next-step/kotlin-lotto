package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersValidatorTest : DescribeSpec({
    describe("로또 번호 검증기 테스트") {
        it("입력된 번호가 6개일 경우 로또 객체를 생성할 수 있다.") {
            val lottoNumbers = listOf(1, 2, 3, 4, 6, 45)

            LottoNumbersValidator.validate(lottoNumbers) shouldBe true
        }

        it("입력된 번호가 6개가 아닐 경우 로또 객체를 생성할 수 없다.") {
            val lottoNumbers = listOf(1, 2, 3, 4, 6, 7, 8)

            LottoNumbersValidator.validate(lottoNumbers) shouldBe false
        }

        it("입력된 번호가 범위가 1미만 45 초과일 경우 로또 객체를 생성할 수 없다.") {
            val lottoNumbers = listOf(1, 2, 3, 4, 6, 77)

            LottoNumbersValidator.validate(lottoNumbers) shouldBe false
        }
    }
})