package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domin.LottoMachine
import lotto.domin.LottoNumberSet
import lotto.dto.InputLottoMachineRequestDto
import lotto.util.LottoNumberGenerator

class LottoMachineTest : FreeSpec({

    "init" - {

        "주어진 금액이 1000원 미만일 경우 IllegalArgumentException" {
            val payment = "100"
            val lottoNumberCount = "2"
            val inputManualLotto = listOf(LottoNumberSet(listOf(1, 2, 3, 4, 5, 6)))

            val dto = InputLottoMachineRequestDto.of(payment, lottoNumberCount, inputManualLotto)
            val lottoNumberGenerator = LottoNumberGenerator.Fake(listOf(1, 2, 3, 4, 5, 6))
            val exception = shouldThrow<IllegalArgumentException> {
                LottoMachine(dto, lottoNumberGenerator)
            }
            exception.message shouldBe LottoMachine.INVALID_PAYMENT
        }

        "주어진 금액이 로또 가격으로 나누어 떨어지지 않을 경우 IllegalArgumentException" {
            val payment = "1100"
            val lottoNumberCount = "2"
            val inputManualLotto = listOf(LottoNumberSet(listOf(1, 2, 3, 4, 5, 6)))

            val dto = InputLottoMachineRequestDto.of(payment, lottoNumberCount, inputManualLotto)
            val lottoNumberGenerator = LottoNumberGenerator.Fake(listOf(1, 2, 3, 4, 5, 6))
            val exception = shouldThrow<IllegalArgumentException> {
                LottoMachine(dto, lottoNumberGenerator)
            }
            exception.message shouldBe LottoMachine.CANNOT_ISSUANCE_LOTTO
        }

        "주어진 금액으로 구매할 수 있는 로또 수 보다 수동 로또 개수 입력 값이 큰 경우 IllegalArgumentException" {
            val payment = "1000"
            val lottoNumberCount = "2"
            val inputManualLotto = listOf(LottoNumberSet(listOf(1, 2, 3, 4, 5, 6)))

            val dto = InputLottoMachineRequestDto.of(payment, lottoNumberCount, inputManualLotto)
            val lottoNumberGenerator = LottoNumberGenerator.Fake(listOf(1, 2, 3, 4, 5, 6))
            val exception = shouldThrow<IllegalArgumentException> {
                LottoMachine(dto, lottoNumberGenerator)
            }
            exception.message shouldBe LottoMachine.EXCEED_PAYMENT
        }
    }
})
