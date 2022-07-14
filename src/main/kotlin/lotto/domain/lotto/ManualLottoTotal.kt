package lotto.domain.lotto

@JvmInline
value class ManualLottoTotal(val value: Int) {
    init {
        require(value >= 0) { "수동 로또 수는 항상 0이상이에요. given: $value" }
    }
}
