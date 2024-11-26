package lotto.domain

@JvmInline
value class LottoCount(val count: Int) {
    override fun toString(): String {
        return "$count"
    }
}
