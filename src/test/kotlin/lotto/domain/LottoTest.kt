package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    lateinit var sequentialNumberGenerator: LottoNumberGenerator

    beforeTest {
        sequentialNumberGenerator =
            object : LottoNumberGenerator {
                var lottoNumberRanger = (1..45).toMutableList()

                override fun generateLottoNumber(): Int {
                    if (lottoNumberRanger.isEmpty()) {
                        lottoNumberRanger = (1..45).toMutableList()
                    }
                    return lottoNumberRanger.removeFirst()
                }
            }
    }

    "로또를 발급한다." {
        shouldNotThrowAny {
            Lotto(sequentialNumberGenerator)
        }
    }

    "로또를 직접 초기화할때 중복되지 않은 6개의 숫자와 1개의 보너스 숫자를 입력해야한다." {
        listOf(
            Pair(listOf(1, 2, 3, 4), 45),
            Pair(listOf(1, 1, 2, 3, 4, 5), 45),
            Pair(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 45),
        ).forAll { (numberList, bonus) ->
            shouldThrowAny {
                Lotto(sequentialNumberGenerator).setLottoByManual(bonus, *numberList.toIntArray())
            }
        }
    }

    "발급된 로또의 로또번호 갯수는 6개이다." {
        Lotto(sequentialNumberGenerator).lottoNumbers.size shouldBe 6
    }

    "각 로또의 번호 및 보너스 번호를 매칭하여 결과를 도출한다." {
        listOf(
            Triple(30, listOf(45, 44, 43, 42, 41, 40), null),
            Triple(30, listOf(1, 45, 44, 43, 42, 41), null),
            Triple(30, listOf(1, 2, 45, 44, 43, 42), null),
            Triple(30, listOf(1, 2, 3, 45, 44, 43), MatchingResult.MATCHED_THREE),
            Triple(30, listOf(1, 2, 3, 4, 45, 44), MatchingResult.MATCHED_FOUR),
            Triple(30, listOf(1, 2, 3, 4, 5, 45), MatchingResult.MATCHED_FIVE),
            Triple(30, listOf(1, 2, 3, 4, 5, 45), MatchingResult.MATCHED_FIVE),
            Triple(30, listOf(1, 2, 3, 4, 5, 6), MatchingResult.MATCHED_SIX),
        ).forAll { (bonusNumber, winningNumbers, matchingResult) ->
            Lotto(sequentialNumberGenerator).apply { setLottoByManual(15, 1, 2, 3, 4, 5, 6) }
                .match(winningNumbers.map { LottoNumber.get(it) }, LottoNumber.get(bonusNumber)) shouldBe matchingResult
        }
    }
})
