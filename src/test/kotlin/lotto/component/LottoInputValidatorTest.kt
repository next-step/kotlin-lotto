package lotto.component

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row

class LottoInputValidatorTest : FunSpec({
    val validator = LottoInputValidator()

    test("구매 금액 잘못된 입력 시 IllegalArgumentException 예외 발생 테스트") {
        forAll(
            row(null),
            row("-1"),
            row("0"),
            row("abc"),
        ) { purchasePrice ->
            shouldThrow<IllegalArgumentException> {
                validator.validatePurchasePrice(purchasePrice)
            }
        }
    }

    test("로또를 구매할 수 없는 경우 금액 IllegalArgumentException 예외 발생 테스트") {
        val lottoNumbersCount = 0

        shouldThrow<IllegalArgumentException> {
            validator.validateLottoNumbersCount(lottoNumbersCount)
        }
    }

    test("로또 번호가 6자리가 아닌 경우 IllegalArgumentException 예외 발생 테스트") {
        val lottoNumbers = listOf(1, 2, 3, 4, 5)

        shouldThrow<IllegalArgumentException> {
            validator.validateLottoNumberCount(lottoNumbers)
        }
    }

    test("로또 번호가 숫자가 아닐 경우 IllegalArgumentException 예외 발생 테스트 ") {
        forAll(
            row("a"),
            row("abc"),
        ) { lottoNumber ->
            shouldThrow<IllegalArgumentException> {
                validator.validateLottoNumber(lottoNumber)
            }
        }
    }

    test("로또 번호가 1~45 범위 내 자연수가 아닐 경우 IllegalArgumentException 예외 발생 테스트 ") {
        forAll(
            row("0"),
            row("-1"),
            row("46"),
        ) { lottoNumber ->
            shouldThrow<IllegalArgumentException> {
                validator.validateLottoNumber(lottoNumber)
            }
        }
    }
})
