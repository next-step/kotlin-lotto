package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll

class WinningLottoTest : StringSpec({
    "당첨로또는 번호를 직접 입력해 생성한다" {
        val winningLotto = WinningLotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)))
        winningLotto.lottoNumbers.numbers shouldContainAll setOf(1, 2, 3, 4, 5, 6)
    }
})
