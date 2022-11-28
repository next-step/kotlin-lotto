package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class LottoMachineTest : StringSpec({
    "6숫자를 입력하면 로또를 생성한다." {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = LottoMachine.generateLotto(numbers)

        lotto.lottoNumbers shouldHaveSize 6
    }

    "자동으로 생성된 로또숫자는 6자리 숫자다." {
        val lottoNumbers = LottoMachine.generateLottoNumbers()

        lottoNumbers shouldHaveSize 6
    }
})
