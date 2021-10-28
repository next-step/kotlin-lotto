package lotto.view

import lotto.model.Lotto

/**
 * 로또 관련된 결과를 알려주는 클래스
 * */
class OutputView {
    // 구매한 로또 개수 출력
    fun resultLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    // 로또 당첨 번호 출력
    fun printNumber(lottos: List<Lotto>) {
        lottos.forEach {
            println("[${it.numbers.map { it.number }.joinToString()}]")
        }
    }

}
