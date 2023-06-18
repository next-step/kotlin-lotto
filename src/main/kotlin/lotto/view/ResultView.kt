package lotto.view

import lotto.domain.Lotto

class ResultView {

    fun showLottoCount(lottos: List<Lotto>) {
        return println("${lottos.size}개를 구매했습니다.")
    }
    fun showLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.lottoNumbers)
        }
    }
}