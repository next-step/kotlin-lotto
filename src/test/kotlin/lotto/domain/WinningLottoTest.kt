package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll

class WinningLottoTest : StringSpec({
    "당첨로또는 번호를 직접 입력해 생성한다" {
        val winningLotto =
            WinningLotto(
                lottoNumbers = LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)),
                bonus = LottoNumber(45),
            )
        winningLotto.lottoNumbers.numbers.map { it.number } shouldContainAll setOf(1, 2, 3, 4, 5, 6)
    }

    "로또 번호 목록고 보너스 번호가 일치하면 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(
                lottoNumbers = LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)),
                bonus = LottoNumber(1),
            )
        }
    }
})
