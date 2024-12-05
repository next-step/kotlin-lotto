package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber

class LottoCreatorTest : StringSpec({
    "입력된 개수만큼의 로또를 생성할 수 있다." {
        val lottoCreator = LottoCreator(FixedLottoNumberGenerator())

        val result = lottoCreator.createAutoLottos(5)

        result.size shouldBe 5
    }

    "입력된 숫자를 가진 수동 로또를 생성할 수 있다." {
        val lottoCreator = LottoCreator(FixedLottoNumberGenerator())
        val manualLottos = lottoCreator.createManualLottos(listOf(createLottoNumberSet(1, 2, 3, 4, 5, 6)))

        manualLottos[0].numbers shouldBe createLottoNumberSet(1, 2, 3, 4, 5, 6)
    }

    "입력된 숫자를 가진 당첨 로또를 생성할 수 있다." {
        val lottoCreator = LottoCreator(FixedLottoNumberGenerator())

        val result = lottoCreator.createWinningLotto(setOf(1, 2, 3, 4, 5, 6), 7)

        result.winningNumbers shouldBe Lotto.from(FixedLottoNumberGenerator().generate())
        result.bonusNumber shouldBe LottoNumber.getNumber(7)
    }
})
