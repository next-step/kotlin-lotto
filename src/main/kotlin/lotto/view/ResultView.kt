package lotto.view

import lotto.domain.LottoNumbers

object ResultView {
    fun printLotto(lottoList: List<LottoNumbers>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        println()
    }
}
