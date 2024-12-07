package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또를 발급한다." {
        shouldNotThrowAny {
            Lotto(RandomGenerator)
        }
    }

    "로또를 직접 초기화할때 중복되지 않은 6개의 숫자를 입력해야한다." {
        listOf(
            listOf(1, 2, 3, 4),
            listOf(1, 1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        ).forAll { numberList ->
            shouldThrowAny {
                Lotto(RandomGenerator).setLottoByManual(*numberList.toIntArray())
            }
        }
    }

    "발급된 로또의 로또번호 갯수는 6개이다." {
        Lotto(RandomGenerator).lottoNumbers.size shouldBe 6
    }

    "각 로또의 번호를 매칭하여 결과를 도출한다." {
        listOf(
            Pair(listOf(45, 44, 43, 42, 41, 40), null),
            Pair(listOf(1, 45, 44, 43, 42, 41), null),
            Pair(listOf(1, 2, 45, 44, 43, 42), null),
            Pair(listOf(1, 2, 3, 45, 44, 43), MatchingResult.MATCHED_THREE),
            Pair(listOf(1, 2, 3, 4, 45, 44), MatchingResult.MATCHED_FOUR),
            Pair(listOf(1, 2, 3, 4, 5, 45), MatchingResult.MATCHED_FIVE),
            Pair(listOf(1, 2, 3, 4, 5, 6), MatchingResult.MATCHED_SIX),
        ).forAll { (winningNumbers, matchingResult) ->
            Lotto(RandomGenerator).apply { setLottoByManual(1, 2, 3, 4, 5, 6) }
                .match(winningNumbers.map { LottoNumber.get(it) }) shouldBe matchingResult
        }
    }
})
