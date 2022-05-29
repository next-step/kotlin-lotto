package lotto.view

import lotto.domain.Lotto

object ResultView {
    fun showLottos(lottos: List<Lotto>) {
        val lottoCount = lottos.size
        println("${lottoCount}개를 구매했습니다.")
        lottos.map { lotto ->
            println(lotto.lottoNumbers.map { it })
        }
    }
}
