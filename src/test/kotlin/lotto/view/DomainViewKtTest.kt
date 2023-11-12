package lotto.view

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumbers

class DomainViewKtTest : FunSpec({
    test("로또의 상태를 출력하면 부여받은 숫자 6개를 출력한다.") {
        val lotto = Lotto(LottoNumbers(setOf(10, 20, 17, 45, 15, 6)))
        lotto.state() shouldBe "[10, 20, 17, 45, 15, 6]"
    }
})
