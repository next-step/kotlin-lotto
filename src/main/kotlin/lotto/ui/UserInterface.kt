package lotto.ui

import lotto.domain.Lottos

object UserInterface {

    fun showNumbers(lottos: Lottos) {
        val lottoList = lottos.lottoList
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.getNumberValues())
        }
    }
}
