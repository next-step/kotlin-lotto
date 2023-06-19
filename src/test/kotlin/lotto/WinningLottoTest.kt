package lotto

import io.kotest.core.spec.style.FunSpec

class WinningLottoTest : FunSpec({
    val winningLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 10))

    test("당첨 로또번호와 보너스 로또번호가 중복되면 예외가 발생한다") {
        WinningLotto(winningLotto, LottoNumber(9))
    }
})
