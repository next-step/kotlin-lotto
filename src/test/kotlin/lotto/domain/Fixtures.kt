package lotto.domain

internal fun createLotto(nums: List<Int>): Lotto {
    return Lotto(nums.map { LottoNum.from(it) })
}
