package lotto.domain.shop

import shffule.MockLottoNumberDescendingSortShuffler
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RealLottoGameMachineTest : StringSpec({

    "로또 게임에 담긴 로또 번호 목록은 오름차순 정렬이 되어있다" {
        val lottoGame = LottoGameMachine(MockLottoNumberDescendingSortShuffler()).create()
        lottoGame.lottoNumbers.value shouldBe lottoGame.lottoNumbers.value.sorted()
    }
})
