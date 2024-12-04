package lotto.domain

@JvmInline
value class ManualLottoAmount(
    val value: Int,
) {
    init {
        require(this.value >= 0) { "수동 로또 갯수는 유효한 양수로 입력해야합니다." }
    }
}
