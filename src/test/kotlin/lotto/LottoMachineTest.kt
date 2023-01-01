package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.ManualLottoStrings
import lotto.domain.ManualLottos
import org.assertj.core.api.Assertions

class LottoMachineTest : StringSpec({

    "로또 1장의 가격은 1000원 이다" {
        val manualLottoStrings = ManualLottoStrings(2, listOf("1,2,3,4,5,6", "1,2,3,4,5,6"))
        val manualLottos = ManualLottos(manualLottoStrings)

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoMachine(100, manualLottos) }
    }

    "로또 하나의 숫자는 6개 이다" {
        val numbers = (1..7).map { LottoNumber(it) }

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(numbers.toSet()) }
    }

    "생성한 난수 6개는 중복이 없어야 한다." {
        val manualLottoStrings = ManualLottoStrings(1, listOf("1,2,3,4,5,6"))
        val manualLottos = ManualLottos(manualLottoStrings)
        val lottoMachine = LottoMachine(2000, manualLottos)
        val lottoList = lottoMachine.autoLottos

        lottoList.size shouldBe lottoList.distinct().size
    }

    "로또 n장에 따라 난수 6개씩 n개 생성" {
        val manualLottoStrings = ManualLottoStrings(1, listOf("1,2,3,4,5,6"))
        val manualLottos = ManualLottos(manualLottoStrings)
        val lottoMachine = LottoMachine(14000, manualLottos)

        val lottoList = lottoMachine.publishLotto()

        lottoList.size shouldBe lottoMachine.purchaseCount
    }
})
