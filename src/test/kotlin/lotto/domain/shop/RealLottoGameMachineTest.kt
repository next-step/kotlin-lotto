package lotto.domain.shop

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.lottonumber.lottoNumbers
import lotto.domain.shop.lottonumberprovider.MockLottoNumberProvider
import lotto.domain.shop.lottonumberprovider.RealLottoNumberProvider
import shffule.MockNotShuffleShuffler
import shffule.RandomShuffler

class RealLottoGameMachineTest : StringSpec({

    "수동 옵션으로 생성하면 수동 타입의 로또 게임을 반환한다" {
        val lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 6)
        val selfOption = LottoGameMachineOption.Self(lottoNumbers)
        val lottoGame = LottoGameMachine(RealLottoNumberProvider(), RandomShuffler())
        lottoGame.create(selfOption).type shouldBe LottoGameType.SELF
    }

    "수동 옵션으로 생성하면 전달한 로또 번호가 담긴 로또 게임을 반환한다" {
        val lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 6)
        val selfOption = LottoGameMachineOption.Self(lottoNumbers)
        val lottoGame = LottoGameMachine(RealLottoNumberProvider(), RandomShuffler())
        lottoGame.create(selfOption).lottoNumbers shouldBe lottoNumbers
    }

    "자동 옵션으로 생성하면 자동 옵션 타입의 로또 게임을 반환한다" {
        val autoOption = LottoGameMachineOption.Auto
        val lottoGame = LottoGameMachine(RealLottoNumberProvider(), RandomShuffler())
        lottoGame.create(autoOption).type shouldBe LottoGameType.AUTO
    }

    "로또 게임에 담긴 로또 번호 목록은 오름차순 정렬이 되어있다" {
        // given
        val descendingLottoNumbers = lottoNumbers(6, 5, 4, 3, 2, 1)
        val ascendingLottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 6)

        // when
        val lottoGame = LottoGameMachine(
            lottoNumberProvider = MockLottoNumberProvider(descendingLottoNumbers.value),
            shuffler = MockNotShuffleShuffler()
        ).create(LottoGameMachineOption.Auto)

        // then
        lottoGame.lottoNumbers.value shouldBe ascendingLottoNumbers.value
    }
})
