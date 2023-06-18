package lotto.domain.shop.machine

import common.shffule.MockLottoNumberDescendingSortShuffler
import common.shffule.MockNotShuffleShuffler
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RealLottoGameMachineTest : StringSpec({

    "한장의 로또 게임에 담긴 로또 번호 개수는 6개이다" {
        val lottoGame = RealLottoGameMachine(MockNotShuffleShuffler()).create()
        lottoGame.numbers.size shouldBe 6
    }

    "로또 게임에 담긴 로또 번호 목록에는 중복이 없다" {
        val lottoGame = RealLottoGameMachine(MockNotShuffleShuffler()).create()
        lottoGame.numbers.distinct() shouldBe lottoGame.numbers
    }

    "로또 게임에 담긴 로또 번호 목록은 오름차순 정렬이 되어있다" {
        val lottoGame = RealLottoGameMachine(MockLottoNumberDescendingSortShuffler()).create()
        lottoGame.numbers shouldBe lottoGame.numbers.sorted()
    }
})
