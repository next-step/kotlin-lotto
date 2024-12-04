package lotto.domain

import io.kotest.core.spec.style.DescribeSpec

class StatisticsTest : DescribeSpec({
    describe("사용자의 당첨 로또를 집계한다") {
        lateinit var winningLotto: WinningLotto
        beforeTest { winningLotto = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber(10)) }
    }
})
