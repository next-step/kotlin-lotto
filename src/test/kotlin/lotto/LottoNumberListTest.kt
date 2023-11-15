package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.Lotto
import lotto.domain.model.vo.LottoNumberList

/**
 * 로또 번호 리스트 테스트
 * */
class LottoNumberListTest : FunSpec({

    test("로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumberList.valueOf(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    test("로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 6, 7]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumberList.valueOf(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    test("로또 번호 리스트 생성시 [0, 2, 3, 4, 5, 6]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumberList.valueOf(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    test("로또 번호 리스트 생성시 [41, 42, 43, 44, 45, 46]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumberList.valueOf(listOf(41, 42, 43, 44, 45, 46))
        }
    }

    test("로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 6]을 넣을 경우 [1, 2, 3, 4, 5, 6]을 가지고 있는 로또 번호 리스트가 생성 되어야 한다.") {
        val lotto = Lotto(LottoNumberList.valueOf(listOf(1, 2, 3, 4, 5, 6)))
        lotto.lottoNumberList.numberList[0].number shouldBe 1
        lotto.lottoNumberList.numberList[1].number shouldBe 2
        lotto.lottoNumberList.numberList[2].number shouldBe 3
        lotto.lottoNumberList.numberList[3].number shouldBe 4
        lotto.lottoNumberList.numberList[4].number shouldBe 5
        lotto.lottoNumberList.numberList[5].number shouldBe 6
    }
})
