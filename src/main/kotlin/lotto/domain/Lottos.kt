package lotto.domain

@JvmInline
value class Lottos(val value: List<Lotto>) {
    init {
        require(value.size == value.toSet().size) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getList(): List<List<Int>> {
        return value.map { lotto -> lotto.value }
    }
}
