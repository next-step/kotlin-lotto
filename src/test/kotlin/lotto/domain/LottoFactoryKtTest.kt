package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoFactoryKtTest : StringSpec({
    "입력한 갯수만큼 로또를 자동으로 생성한다" {
        // given
        val lottoNumber = 3

        // when
        val actual = LottoFactory.generateAutoLottos(lottoNumber)

        // then
        actual.lottos.size shouldBe lottoNumber
    }
})
