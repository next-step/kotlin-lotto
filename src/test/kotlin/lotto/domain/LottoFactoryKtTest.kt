package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
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

    "수동 로또를 생성한다." {
        // given
        val manualLottos = listOf(
            Lotto.of(1, 2, 3, 4, 5, 6),
            Lotto.of(10, 11, 12, 13, 14, 15),
        )

        // when
        val actual = LottoFactory.generateManualLottos(manualLottos)

        // then
        actual.lottos.size shouldBe 2
        actual.lottos[0].lottoNumbers shouldContainInOrder listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.valueOf(it) }
        actual.lottos[1].lottoNumbers shouldContainInOrder listOf(10, 11, 12, 13, 14, 15).map { LottoNumber.valueOf(it) }
    }
})
