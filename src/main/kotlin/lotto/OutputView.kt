package lotto

object OutputView {
    fun showUserLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it)
        }
    }
}
