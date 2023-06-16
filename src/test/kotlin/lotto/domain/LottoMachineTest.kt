package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class LottoMachineTest : AnnotationSpec() {

    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`() {
        val lottoes = LottoMachine.buyLottoes(14000)
        lottoes.lottoNumbers shouldHaveSize 14
        lottoes.lottoNumbers.shouldForAll { 6 }
    }

    @Test
    fun `당첨결과를 설정할 수 있어야한다`() {
        LottoMachine.buyLottoes(14000)
        val winNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(winNumber,7)
        LottoMachine.setWinNumbers(winNumber, bonusNumber)
        LottoMachine.getRanking()
        LottoMachine.rateOfReturn shouldBeLessThan 1.0
    }

    @Test
    fun `당첨결과의 경우 중복이 올 수 없고 정해진 범위내의 숫자만 가능`() {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(listOf(1, 2, 2, 2, 3, 4))
        }
    }

    @Test
    fun `보너스 숫자는 당첨 숫자와 중복이 될 수 없음`() {
        val winNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6))
        BonusNumber(winNumber,7).shouldBeTypeOf<BonusNumber>()
        shouldThrow<IllegalArgumentException> {
            BonusNumber(winNumber,6)
        }
    }
}
