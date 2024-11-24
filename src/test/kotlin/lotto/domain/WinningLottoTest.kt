package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.fixture.createLottoFixture

class WinningLottoTest : StringSpec({
    "당첨 로또는 보너스 번호가 당첨 번호에 포함되면 예외를 던진다." {
        val lotto = createLottoFixture(listOf(1, 2, 3, 4, 5, 6))
        shouldThrow<IllegalArgumentException> { WinningLotto(lotto, Number(6)) }
    }
})
