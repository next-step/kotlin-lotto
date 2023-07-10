package lotto.domain

@JvmInline
value class ManualLottoCount(val count: Int) {
    init {
        require(count > -1) { REQUIRE_POSITIVE_NUMBER }
    }

    companion object {
        private const val REQUIRE_POSITIVE_NUMBER = "0 이상의 숫자를 입력해 주세요."
    }
}
