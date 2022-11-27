package lotto.domain

class Lottos(val lottos : List<Lotto>) {

    fun matchNumbers(winningLotto:Lotto){
        lottos.map {
            it.matchNumberWith(winningLotto)
        }
    }
}
