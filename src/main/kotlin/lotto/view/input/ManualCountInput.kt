package lotto.view.input

data class ManualCountInput(val lottoCount: Int) {
    constructor(lottoCount: String) : this(lottoCount.toIntOrNull() ?: throw IllegalArgumentException("수동 복권 개수는 숫자야여 합니다."))
}
