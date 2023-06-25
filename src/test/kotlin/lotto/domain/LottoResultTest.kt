package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({

    "로또게임의 결과값을 반환한다." {
        val result = LottoResult.calculateResult(
            lottos = Lottos(
                listOf(
                    Lotto(listOf(11, 23, 3, 4, 13, 6).map { LottoNumber(it) }), // 2개 일치
                    Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }), // 3개 일치
                    Lotto(listOf(1, 2, 3, 4, 15, 16).map { LottoNumber(it) }), // 3개 일치
                    Lotto(listOf(3, 4, 5, 18, 8, 14).map { LottoNumber(it) }), // 4개 일치
                    Lotto(listOf(3, 4, 5, 7, 8, 14).map { LottoNumber(it) }), // 5개 일치
                    Lotto(listOf(3, 4, 5, 7, 8, 15).map { LottoNumber(it) }), // 6개 일치
                )
            ),
            lottoResult = WinningLotto(Lotto(listOf(3, 4, 5, 7, 8, 15).map { LottoNumber(it) }), 2),
        )

        with(result) {
            size shouldBe 4
        }
    }
})
