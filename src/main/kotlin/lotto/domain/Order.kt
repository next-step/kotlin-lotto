package lotto.domain

data class Order(private val manual: Int, val auto: Int, val selected: List<LottoNumbers> = listOf()) {

    fun total(): Int {
        return manual + auto
    }

    companion object {
        private fun verify(total: Int, manual: Int, selected: List<LottoNumbers>) {
            require(total >= manual) { "예산을 초과하여 구매할 수 없습니다." }
            require(manual == selected.size) { "수동으로 구매할 로또 번호를 모두 입력해야 합니다." }
        }

        fun of(total: Int, manual: Int, selected: List<LottoNumbers>): Order {
            verify(total, manual, selected)
            return Order(manual, total - manual, selected)
        }
    }
}
