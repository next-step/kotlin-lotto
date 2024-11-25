package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.service.LottoCreator

class LottoCreatorTest : StringSpec({
    "입력된 개수만큼의 로또를 생성할 수 있다." {
        val lottoCreator = LottoCreator(FixedNumberGenerator())

        val result = lottoCreator.createLottos(5)

        result.size shouldBe 5
    }

    "입력된 숫자를 가진 당첨 로또를 생성할 수 있다." {
        val lottoCreator = LottoCreator(FixedNumberGenerator())

        val result = lottoCreator.createWinningLotto(FixedNumberGenerator().generate())

        result.winningNumbers shouldBe Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())
    }
})
