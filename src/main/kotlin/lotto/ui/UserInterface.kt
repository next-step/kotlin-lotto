package lotto.ui

import lotto.domain.Lottos

object UserInterface {

    fun showNumbers(lottos: Lottos, manualCount: Int) {
        val lottoList = lottos.lottoList
        println("수동으로 ${manualCount}장 자등으로 ${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.getNumberValues())
        }
    }
}
