package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.types.shouldBeTypeOf

class LottoMachineTest : AnnotationSpec() {

    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`() {
        val lottoes = LottoMachine.buyLotto(14000)
        lottoes.lottoes shouldHaveSize 14
        lottoes.lottoes.shouldForAll { 6 }
    }

    @Test
    fun `당첨결과를 설정할 수 있어야한다`() {
        LottoMachine.buyLotto(14000)
        val winNumber = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = BonusBall(LottoNumber(7))
        LottoMachine.setWinLotto(winNumber, bonusNumber)
        LottoMachine.generateRanking()
        LottoMachine.rateOfReturn shouldBeLessThan 1.0
    }

    @Test
    fun `당첨결과의 경우 중복이 올 수 없고 정해진 범위내의 숫자만 가능`() {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 2, 2, 3, 4).map { LottoNumber(it) })
        }
    }

    @Test
    fun `당첨 숫자는 6개 이어야함`() {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) })
        }
    }

    @Test
    fun `당첨금을 계산해본다`() {
        LottoMachine.buyLotto(14000)
        val winNumber = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = BonusBall(LottoNumber(7))
        LottoMachine.setWinLotto(winNumber, bonusNumber)
        val ranking = LottoMachine.generateRanking()
        ranking.totalWinAmount.shouldBeTypeOf<Int>()
    }

    fun `보너스 숫자는 당첨 숫자와 중복이 될 수 없음 또한 1보다 작거나 45보다 클 수 없음`() {
        BonusBall(LottoNumber(7)).shouldBeTypeOf<BonusBall>()
        val winNumber = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber((it)) })
        val bonusBall = BonusBall(LottoNumber(6))
        shouldThrow<IllegalArgumentException> {
            LottoMachine.setWinLotto(winNumber, bonusBall)
        }
        shouldThrow<IllegalArgumentException> {
            BonusBall(LottoNumber(0))
        }
    }
}
