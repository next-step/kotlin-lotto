package lotto

class ResultView {

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it)
        }
    }
}
