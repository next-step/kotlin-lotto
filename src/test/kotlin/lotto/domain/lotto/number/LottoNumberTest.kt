package lotto.domain.lotto.number

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows

class LottoNumberTest : FunSpec({
    context("1~45 사이 숫자는 로또 번호 생성이 가능하다") {
        withData(
            (1..45)
        ) { number ->
            LottoNumber(number) shouldNotBe null
        }
    }

    context("1~45 범위 밖의 숫자는 로또 번호 생성이 불가능하다") {
        withData(
            ((-100..0) + (46..100))
        ) { invalidNumber ->
            assertThrows<IllegalArgumentException> {
                LottoNumber(invalidNumber)
            }
        }
    }

    test("로또 번호 6개를 랜덤하게 정상적으로 발급한다.") {
        val givenLottoNumberCount = 6

        val lottoNumberList = LottoNumber.randomShuffle(6)

        lottoNumberList shouldContainInOrder lottoNumberList.sorted()
        lottoNumberList shouldHaveSize givenLottoNumberCount
        lottoNumberList.map { it.number }.toSet() shouldHaveSize givenLottoNumberCount
    }

    context("로또 번호를 1~45개까지 랜덤하게 정상적으로 발급 가능하다.") {
        withData(
            (1..45)
        ) { lottoNumberCount ->
            val lottoNumberList = LottoNumber.randomShuffle(lottoNumberCount)

            lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
            lottoNumberList shouldHaveSize lottoNumberCount
            lottoNumberList.map { it.number }.toSet() shouldHaveSize lottoNumberCount
        }
    }

    context("로또 번호 랜덤 발급 입력값이 0보다 같거나 작으면, IllegalArgumentException") {
        withData(
            (-45..0)
        ) { invalidInput ->
            assertThrows<IllegalArgumentException> { LottoNumber.randomShuffle(invalidInput) }
        }
    }
})
