package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.ManualLottoInfo
import org.assertj.core.api.Assertions

class LottoMachineTest : StringSpec({

    "로또 1장의 가격은 1000원 이다" {
        val manualLottoInfo = ManualLottoInfo(1, listOf("1,2,3,4,5,6"))

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoMachine(100, manualLottoInfo) }
    }

    "로또 하나의 숫자는 6개 이다" {
        val numbers = (1..7).map { LottoNumber(it) }

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(numbers.toSet()) }
    }

    "생성한 난수 6개는 중복이 없어야 한다." {
        val manualLottoInfo = ManualLottoInfo(1, listOf("1,2,3,4,5,6"))
        val lottoMachine = LottoMachine(2000, manualLottoInfo)
        val publishLotto = lottoMachine.publishLotto()

        publishLotto.autoLottos[0].numbers.size shouldBe publishLotto.autoLottos[0].numbers.distinct().size
    }

    "로또 n장에 따라 난수 6개씩 n개 생성" {
        val manualLottoInfo = ManualLottoInfo(1, listOf("1,2,3,4,5,6"))
        val lottoMachine = LottoMachine(14000, manualLottoInfo)

        val publishLotto = lottoMachine.publishLotto()

        publishLotto.allLotto.size shouldBe lottoMachine.purchaseCount
    }

    "수동 입력 개수와 입력받은 로또 숫자목록 개수는 같다" {
        val manualLottoCount = 2
        val manualLottoInfo = ManualLottoInfo(manualLottoCount, listOf("1,2,3,4,5,6", "1,2,3,4,5,6"))
        val lottoMachine = LottoMachine(2000, manualLottoInfo)

        val publishLotto = lottoMachine.publishLotto()

        publishLotto.allLotto.size shouldBe manualLottoCount
    }

    "수동 입력 개수0" {
        val manualLottoInfo = ManualLottoInfo(0, emptyList())
        val lottoMachine = LottoMachine(2000, manualLottoInfo)

        val publishLotto = lottoMachine.publishLotto()

        publishLotto.allLotto.size shouldBe lottoMachine.purchaseCount
    }
})
