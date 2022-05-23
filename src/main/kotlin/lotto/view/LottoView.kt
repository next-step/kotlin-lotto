package lotto.view

import lotto.domain.Lotto

class LottoView(private val output: Output, private val lottos: List<Lotto>) {

    fun print() {
        output.print("${lottos.size}개를 구매했습니다.")

        lottos.forEach { lotto ->
            output.print(lotto.numbers.map { it.value }.toString())
        }
    }
}
