package lotto.domain

class Lottos (
    val lottos: List<Lotto>
){

    fun getTotalCount(): Int {
        return lottos.size
    }
}
