package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest:StringSpec({


    "로또게임의 결과값을 반환한다."{
        val result = LottoResult.calculateResult(
            lottos = Lottos(
                listOf(
                    Lotto(listOf(11,23,3,4,13,6)), // 2개 일치
                    Lotto(listOf(1,2,3,4,5,6)), // 3개 일치
                    Lotto(listOf(1,2,3,4,15,16)), // 3개 일치
                    Lotto(listOf(3,4,5,18,8,14)), // 4개 일치
                    Lotto(listOf(3,4,5,7,8,14)), // 5개 일치
                    Lotto(listOf(3,4,5,7,8,15)), // 6개 일치
                )
            ),
            lottoResult = Lotto(listOf(3,4,5,7,8,15)),
        )

        with(result) {
            size shouldBe 4
        }
    }
})

