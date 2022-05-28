package lotto.view

import lotto.domain.Lotto

class LottoView(private val output: Output, private val lottos: List<Lotto>) {

    fun print() {
        val (auto, manual) = lottos.partition { it.isAuto }
        output.print("\n수동으로 ${manual.size}장, 자동으로 ${auto.size}개를 구매했습니다.")

        lottos.forEach { lotto ->
            output.print(lotto.numbers.map { it.value }.toString())
        }
    }
}
