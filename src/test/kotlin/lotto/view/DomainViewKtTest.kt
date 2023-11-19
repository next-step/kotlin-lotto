package lotto.view

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import lotto.domain.LottoGameResult
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoReward

class DomainViewKtTest : FunSpec({
    test("로또의 상태를 출력하면 부여받은 숫자 6개를 출력한다.") {
        val lotto = LottoNumbers(
            setOf(
                LottoNumber(10),
                LottoNumber(20),
                LottoNumber(17),
                LottoNumber(45),
                LottoNumber(15),
                LottoNumber(6)
            )
        )
        lotto.state() shouldBe "[10, 20, 17, 45, 15, 6]"
    }

    test("로또 게임결과의 상태를 출력하면 2등이 몇명인지 출력된다.") {
        val lottoGameResult =
            LottoGameResult(totalPrice = 3000, rewards = listOf(LottoReward.FIRST, LottoReward.SECOND))
        lottoGameResult.state() shouldContain "5개 일치, 보너스 볼 일치 (30000000원) - 1개"
    }
})
