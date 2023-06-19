package lotto.domain.shop

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.lottonumber.LottoNumber
import lotto.domain.shop.lottonumberprovider.MockLottoNumberProvider
import shffule.MockNotShuffleShuffler

class RealLottoGameMachineTest : StringSpec({

    "로또 게임에 담긴 로또 번호 목록은 오름차순 정렬이 되어있다" {
        // given
        val descendingLottoNumbers = listOf(6, 5, 4, 3, 2, 1).map { LottoNumber(it) }
        val ascendingLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }

        // when
        val lottoGame = LottoGameMachine(
            lottoNumberProvider = MockLottoNumberProvider(descendingLottoNumbers),
            shuffler = MockNotShuffleShuffler()
        ).create()

        // then
        lottoGame.lottoNumbers.value shouldBe ascendingLottoNumbers
    }
})
