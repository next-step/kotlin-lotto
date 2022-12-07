package nextstep.mission.lotto.vo

private const val LOTTO_MINIMUM_NUMBER = 1
private const val LOTTO_MAXIMUM_NUMBER = 45

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER) { "로또 숫자는 1에서 45사이어야 합니다." }
    }
}
