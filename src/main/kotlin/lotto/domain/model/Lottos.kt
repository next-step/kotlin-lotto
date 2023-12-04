package lotto.domain.model

/**
 * 로또 리스트 객체
 * */
class Lottos(private val value: List<Lotto>): List<Lotto> by value {

    init {
        require(value.isNotEmpty()) {
            "로또들은 비어 있을 수 없다."
        }
    }

    operator fun plus(lottos: List<Lotto>) = Lottos(value + lottos)
    companion object {
        fun from(lottoList: List<Lotto>) = Lottos(lottoList)
    }
}
