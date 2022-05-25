package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domin.LottoMachine
import lotto.dto.InputPaymentRequestDto
import lotto.util.LottoNumberGenerator

class LottoMachineTest : FreeSpec({

    "init" - {

        "주어진 금액이 1000원 미만일 경우 IllegalArgumentException" {
            val payment = "100"
            val dto = InputPaymentRequestDto.convertPayment(payment)
            val lottoNumberGenerator = LottoNumberGenerator.Fake(listOf(1, 2, 3, 4, 5, 6))
            val exception = shouldThrow<IllegalArgumentException> {
                LottoMachine(dto, lottoNumberGenerator)
            }
            exception.message shouldBe LottoMachine.INVALID_PAYMENT
        }

        "주어진 금액이 로또 가격으로 나누어 떨어지지 않을 경우 IllegalArgumentException" {
            val payment = "1100"
            val dto = InputPaymentRequestDto.convertPayment(payment)
            val lottoNumberGenerator = LottoNumberGenerator.Fake(listOf(1, 2, 3, 4, 5, 6))
            val exception = shouldThrow<IllegalArgumentException> {
                LottoMachine(dto, lottoNumberGenerator)
            }
            exception.message shouldBe LottoMachine.CANNOT_ISSUANCE_LOTTO
        }
    }

    "sellLotto" - {

        "입력한 금액에 맞는 로또의 수가 나와야한다." {
            val payment = "2000"
            val dto = InputPaymentRequestDto.convertPayment(payment)
            val fakeNumber = listOf(1, 2, 3, 4, 5, 6)
            val lottoNumberGenerator = LottoNumberGenerator.Fake(fakeNumber)
            val lottoMachine = LottoMachine(dto, lottoNumberGenerator)

            lottoMachine.sellLotto()

            lottoMachine.lottoRecord.size shouldBe 2
            lottoMachine.lottoRecord[0].lotto shouldBe fakeNumber
        }
    }
})
